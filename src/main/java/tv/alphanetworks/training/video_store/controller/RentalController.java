package tv.alphanetworks.training.video_store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.training.video_store.dtos.RentalDto;
import tv.alphanetworks.training.video_store.dtos.RentalRequestDto;
import tv.alphanetworks.training.video_store.dtos.ReturnRequestDto;
import tv.alphanetworks.training.video_store.dtos.CustomerDto;
import tv.alphanetworks.training.video_store.services.CustomerService;
import tv.alphanetworks.training.video_store.services.RentalService;

import java.util.List;

@RestController
@RequestMapping(value = "/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    private final CustomerService customerService;

    @GetMapping(value = "/getRents")
    public ResponseEntity<List<RentalDto>> list() {
        return ResponseEntity.ok(this.rentalService.getAll());
    }

    @PostMapping("/rent")
    public ResponseEntity<?> rentMovies(@RequestBody RentalRequestDto request) {
        try {
            RentalDto rental = rentalService.rentMovies(request);
            return ResponseEntity.ok(rental);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @GetMapping("/checkLateReturns/{customerId}")
    public ResponseEntity<String> checkLateReturns(@PathVariable Long customerId) {
        CustomerDto customer = customerService.getById(customerId);
        boolean hasLateReturns = rentalService.checkLateReturns(customer);
        if (hasLateReturns) {
            return ResponseEntity.ok("Customer with ID: " + customerId + " has late returns.");
        } else {
            return ResponseEntity.ok("Customer with ID: " + customerId + " has no late returns.");
        }
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnRents(@RequestBody ReturnRequestDto returnRequestDto) {
        Long customerId = returnRequestDto.getCustomerId();
        List<Long> rentalIds = returnRequestDto.getRentalIds();

        boolean rentalsReturned = rentalService.returnRentals(customerId, rentalIds);

        if (rentalsReturned) {
            return ResponseEntity.ok("Rentals returned successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to return rentals.");
        }
    }
}
