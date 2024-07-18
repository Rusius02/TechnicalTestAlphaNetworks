package tv.alphanetworks.training.video_store.services;

import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.dtos.RentalDto;
import tv.alphanetworks.training.video_store.dtos.RentalRequestDto;

import java.util.List;

public interface RentalService {
    List<RentalDto> getAll();
    RentalDto rentMovies(RentalRequestDto rentalRequestDto);
    List<RentalDto> getRentalsFromCustomer(CustomerDto customer);

    boolean checkLateReturns(CustomerDto customer);
    boolean returnRentals(Long customerId, List<Long> rentalIds);
}
