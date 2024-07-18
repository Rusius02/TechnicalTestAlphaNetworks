package tv.alphanetworks.training.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.alphanetworks.training.video_store.model.Customer;
import tv.alphanetworks.training.video_store.model.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository <Rental, Long> {
    List<Rental> findByCustomer(Customer customer);
    List<Rental> findByCustomerIdAndIdIn(Long customerId, List<Long> rentalIds);
}
