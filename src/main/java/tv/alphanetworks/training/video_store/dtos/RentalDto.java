package tv.alphanetworks.training.video_store.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RentalDto {
    private Long id;
    private LocalDateTime rentalDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime returnDate;
    private double price;
    private List<MovieDto> movies;
    private CustomerDto customer;
}
