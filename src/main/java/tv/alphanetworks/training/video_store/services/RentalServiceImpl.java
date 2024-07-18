package tv.alphanetworks.training.video_store.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.dtos.RentalDto;
import tv.alphanetworks.training.video_store.dtos.RentalRequestDto;
import tv.alphanetworks.training.video_store.mappers.*;
import tv.alphanetworks.training.video_store.model.Customer;
import tv.alphanetworks.training.video_store.model.DVD;
import tv.alphanetworks.training.video_store.model.Movie;
import tv.alphanetworks.training.video_store.model.Rental;
import tv.alphanetworks.training.video_store.repository.CustomerRepository;
import tv.alphanetworks.training.video_store.repository.MovieRepository;
import tv.alphanetworks.training.video_store.repository.RentalRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl  implements RentalService{
    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;


    @Override
    public List<RentalDto> getAll() {
        List<Rental> rental = this.rentalRepository.findAll();
        return MyRentalMapper.toDtoList(rental);
    }

    @Override
    public List<RentalDto> getRentalsFromCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findByCustomerNumber(customerDto.getCustomerNumber());
        if (customer == null) {
            throw new RuntimeException("Customer not found in the system.");
        }

        List<Rental> rentals = this.rentalRepository.findByCustomer(customer);
        return MyRentalMapper.toDtoList(rentals);
    }

    @Override
    public RentalDto rentMovies(RentalRequestDto requestDto) {
        Customer customer = customerRepository.findByCustomerNumber(requestDto.getCustomerDto().getCustomerNumber());
        if (customer == null) {
            customer = customerRepository.save(MyCustomerMapper.toEntity(requestDto.getCustomerDto()));
        }

        if (checkLateReturns(requestDto.getCustomerDto())) {
            throw new RuntimeException("The customer cannot rent movies due to late returns.");
        }

        List<Movie> movies = MyMovieMapper.toEntityList(requestDto.getMoviesDto());
        for (Movie movie : movies) {
            if (!movieRepository.existsByTitle(movie.getTitle())) {
                throw new RuntimeException("Movie " + movie.getTitle() + " is not present in our system.");
            }
            if (!movieRepository.isMovieAvailable(movie.getId())) {
                throw new RuntimeException("Movie " + movie.getTitle() + " is currently not available for rent.");
            }
        }

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setMovies(movies);
        rental.setRentalDate(LocalDateTime.now());
        rental.setExpectedReturnDate(LocalDateTime.now().plusMonths(1));
        rental.setPrice(movies.stream().mapToDouble(movie -> movie instanceof DVD ? 2.0 : 1.0).sum());
        return MyRentalMapper.toDto(rentalRepository.save(rental));
    }

    public boolean checkLateReturns(CustomerDto customerDto) {
        List<RentalDto> rentals = getRentalsFromCustomer(customerDto);

        for (RentalDto rentalDto : rentals) {
            if (rentalDto.getReturnDate() == null && rentalDto.getExpectedReturnDate().isBefore(LocalDateTime.now().minusDays(7))) {
                return true;
            }
        }
        return false;
    }
    public boolean returnRentals(Long customerId, List<Long> rentalIds) {
        List<Rental> rentals = rentalRepository.findByCustomerIdAndIdIn(customerId, rentalIds);
        rentals.forEach(rental -> rental.setReturnDate(LocalDateTime.now()));
        rentalRepository.saveAll(rentals);
        return true;
    }

}
