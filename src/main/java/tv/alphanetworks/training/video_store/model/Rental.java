package tv.alphanetworks.training.video_store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Table(name = "rental")
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime rentalDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime returnDate;
    private double price;
    @ManyToMany
    @JoinTable(
            name = "rental_movie",
            joinColumns = @JoinColumn(name = "rental_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public double calculatePrice() {
        double totalPrice = 0.0;
        for (Movie movie : movies) {
            if (movie instanceof DVD) {
                totalPrice += 2.0;
            } else if (movie instanceof VHS) {
                totalPrice += 1.0;
            }
        }
        return totalPrice;
    }

    public LocalDateTime calculateExpectedReturnDate() {
        return rentalDate.plusMonths(1);
    }
}
