package tv.alphanetworks.training.video_store.dtos;

import lombok.Data;

import java.util.List;

@Data
public class RentalRequestDto {
    private CustomerDto customerDto;
    private List<MovieDto> moviesDto;

}
