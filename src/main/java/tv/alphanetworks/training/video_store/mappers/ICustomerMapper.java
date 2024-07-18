package tv.alphanetworks.training.video_store.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.model.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
    List<CustomerDto> toDtoList(List<Customer> customers);
}
