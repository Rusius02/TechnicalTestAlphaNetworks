package tv.alphanetworks.training.video_store.services;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.mappers.ICustomerMapper;
import tv.alphanetworks.training.video_store.mappers.MyCustomerMapper;
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
    //I've tried to use mapStruct but it was not working, lost 3h trying to make it works
    //private final ICustomerMapper customerMapper;


    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        return MyCustomerMapper.toDtoList(customers);
    }

    @Override
    public CustomerDto getById(Long id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie not found"));
        return MyCustomerMapper.toDto(customer);
    }
    /**
     * Registers a new customer.
     *
     * @param customer The customer object to register.
     * @return ResponseEntity containing the registered customer object with HTTP status 200 (OK).
     */
    @Override
    public CustomerDto register(CustomerDto customer) {
        return MyCustomerMapper.toDto(this.customerRepository.save(MyCustomerMapper.toEntity(customer)));
    }

    @Override
    public List<CustomerDto> getByName(String name) {
        List<Customer> customers = this.customerRepository.findByName(name);
        return MyCustomerMapper.toDtoList(customers);
    }
}
