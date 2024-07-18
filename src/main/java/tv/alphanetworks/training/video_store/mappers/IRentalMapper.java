package tv.alphanetworks.training.video_store.mappers;

import org.mapstruct.Mapper;
import tv.alphanetworks.training.video_store.dtos.RentalDto;
import tv.alphanetworks.training.video_store.dtos.RentalRequestDto;
import tv.alphanetworks.training.video_store.model.Rental;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRentalMapper {
    RentalDto toDto (Rental rental);
    Rental toEntity (RentalRequestDto rentalRequestDto);
    List<RentalDto> toDtoList(List<Rental> rentals);
}
