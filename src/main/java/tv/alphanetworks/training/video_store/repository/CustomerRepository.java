package tv.alphanetworks.training.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tv.alphanetworks.training.video_store.model.Customer;

/**
 * This is a default class , should be updated to work
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
