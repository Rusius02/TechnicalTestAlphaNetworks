package tv.alphanetworks.training.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tv.alphanetworks.training.video_store.model.Customer;

import java.util.List;

/**
 * This is a default class , should be updated to work
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);
    @Query("SELECT c FROM Customer c WHERE c.customerNumber = :customerNumber")
    Customer findByCustomerNumber(@Param("customerNumber") String customerNumber);
    Customer findByCustomerNumberOrEmail(String customerNumber, String email);
}
