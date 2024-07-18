package tv.alphanetworks.training.video_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @OneToOne
    @JoinColumn(name = "parent_cat_id", referencedColumnName = "id")
    private Category categoryParent;
}
