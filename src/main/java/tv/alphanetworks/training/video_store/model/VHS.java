package tv.alphanetworks.training.video_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("VHS")
@Entity
public class VHS extends Movie {
    private Format format;
}
