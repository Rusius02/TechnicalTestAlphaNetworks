package tv.alphanetworks.training.video_store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.services.CustomerService;

import java.util.List;

/**
 * This is a default class , should be updated to work
 */

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/getCustomers")
    public ResponseEntity<List<CustomerDto>> list() {
        return ResponseEntity.ok(this.customerService.getAll());
    }

    @GetMapping(value = "/getCustomerById/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.getById(id));
    }
    @PostMapping (value = "/register")
    public ResponseEntity<CustomerDto> register(@RequestBody CustomerDto customer) throws Exception {
        return ResponseEntity.ok(this.customerService.register(customer));
    }
    @GetMapping("getCustomerByName/{name}")
    public ResponseEntity<List<CustomerDto>> getCustomerByName(@PathVariable String name) {
        List<CustomerDto> customer = customerService.getByName(name);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
