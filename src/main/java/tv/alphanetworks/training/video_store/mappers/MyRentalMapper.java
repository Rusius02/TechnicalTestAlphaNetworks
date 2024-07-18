package tv.alphanetworks.training.video_store.mappers;

import tv.alphanetworks.training.video_store.dtos.RentalDto;
import tv.alphanetworks.training.video_store.model.Rental;

import java.util.ArrayList;
import java.util.List;

public class MyRentalMapper {
    public static RentalDto toDto(Rental rental) {
        if (rental == null) {
            return null;
        }

        RentalDto rentalDto = new RentalDto();
        rentalDto.setId(rental.getId());
        rentalDto.setRentalDate(rental.getRentalDate());
        rentalDto.setExpectedReturnDate(rental.getExpectedReturnDate());
        rentalDto.setReturnDate(rental.getReturnDate());
        rentalDto.setPrice(rental.getPrice());
        rentalDto.setMovies(MyMovieMapper.toListDto(rental.getMovies()));
        rentalDto.setCustomer(MyCustomerMapper.toDto(rental.getCustomer()));

        return rentalDto;
    }

    public static Rental toEntity(RentalDto rentalDto) {
        if (rentalDto == null) {
            return null;
        }

        Rental rental = new Rental();
        rental.setRentalDate(rentalDto.getRentalDate());
        rental.setExpectedReturnDate(rentalDto.getExpectedReturnDate());
        rental.setReturnDate(rentalDto.getReturnDate());
        rental.setPrice(rentalDto.getPrice());
        rental.setMovies(MyMovieMapper.toEntityList(rentalDto.getMovies()));
        rental.setCustomer(MyCustomerMapper.toEntity(rentalDto.getCustomer()));

        return rental;
    }

    public static List<RentalDto> toDtoList(List<Rental> rentals) {
        if (rentals == null) {
            return null;
        }
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental rental : rentals) {
            rentalDtos.add(toDto(rental));
        }
        return rentalDtos;
    }

    public static List<Rental> toEntityList(List<RentalDto> rentalDtos) {
        if (rentalDtos == null) {
            return null;
        }
        List<Rental> rentals = new ArrayList<>();
        for (RentalDto rentalDto : rentalDtos) {
            rentals.add(toEntity(rentalDto));
        }
        return rentals;
    }
}
