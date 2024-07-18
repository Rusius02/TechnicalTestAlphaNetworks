package tv.alphanetworks.training.video_store.dtos;

import lombok.Getter;
import lombok.Setter;
import tv.alphanetworks.training.video_store.model.CategoryEnum;

@Getter
@Setter
public class CategoryDto {
    private CategoryEnum category;
    private CategoryDto categoryParent;
}
