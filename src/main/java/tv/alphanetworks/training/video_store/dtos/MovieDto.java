package tv.alphanetworks.training.video_store.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovieDto {
    private Long id;
    private String type;
    private String title;
    private String category;
    private LocalDateTime releaseDate;
    private String language;
    private Integer numberDiscs;
    private String format;
}
