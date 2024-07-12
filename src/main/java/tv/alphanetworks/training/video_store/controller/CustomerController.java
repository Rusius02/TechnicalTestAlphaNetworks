package tv.alphanetworks.training.video_store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.alphanetworks.training.video_store.model.Customer;
import tv.alphanetworks.training.video_store.services.CustomerService;

import java.util.List;

/**
 * This is a default class , should be updated to work
 */

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity.ok(this.customerService.getAll());
    }
}
