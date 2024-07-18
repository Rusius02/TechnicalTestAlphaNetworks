package tv.alphanetworks.training.video_store.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ReturnRequestDto {
    private Long customerId;
    private List<Long> rentalIds;

    public List<Long> getRentalIds() {
        return rentalIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

}
