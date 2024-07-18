package tv.alphanetworks.training.video_store.mappers;

import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MyCustomerMapper {
    
    public static CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setCustomerNumber(customer.getCustomerNumber());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        return customerDto;
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setCustomerNumber(customerDto.getCustomerNumber());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        return customer;
    }

    public static List<CustomerDto> toDtoList(List<Customer> customers) {
        if (customers == null) {
            return null;
        }
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(toDto(customer));
        }
        return customerDtos;
    }
}
