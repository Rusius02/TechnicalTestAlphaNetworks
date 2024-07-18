package tv.alphanetworks.training.video_store.services;

import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.exceptions.CustomerExceptions;

import java.util.List;

/**
 * This is a default class , should be updated to work
 */

public interface CustomerService {

    List<CustomerDto> getAll();
    CustomerDto getById(Long id);
    CustomerDto register(CustomerDto customer) throws CustomerExceptions;
    List<CustomerDto> getByName(String name);
}
