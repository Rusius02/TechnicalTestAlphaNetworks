package tv.alphanetworks.training.video_store.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tv.alphanetworks.training.video_store.model.Customer;
import tv.alphanetworks.training.video_store.repository.CustomerRepository;

import java.util.List;

/**
 * This is a default class , should be updated to work
 */

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }
}
