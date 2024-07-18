package tv.alphanetworks.training.video_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("DVD")
@Entity
public class DVD extends Movie {
    private int numberDiscs;
}
