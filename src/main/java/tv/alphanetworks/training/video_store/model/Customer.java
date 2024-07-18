package tv.alphanetworks.training.video_store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This is a default class , should be updated to work
 */

@Getter
@Setter
@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerNumber;
    private String name;
    private String email;
    private String phoneNumber;
}
