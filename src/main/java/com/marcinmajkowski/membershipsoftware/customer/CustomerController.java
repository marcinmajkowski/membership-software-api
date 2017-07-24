package com.marcinmajkowski.membershipsoftware.customer;

import com.marcinmajkowski.membershipsoftware.customer.domain.CustomerFacade;
import com.marcinmajkowski.membershipsoftware.customer.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
class CustomerController {

    private final CustomerFacade customerFacade;

    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @GetMapping
    List<CustomerDto> getCustomers() {
        return customerFacade.findAll();
    }

    @GetMapping("/{id}")
    CustomerDto getCustomer(@PathVariable String id) {
        return customerFacade.findById(id);
    }

    @PostMapping
    CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerFacade.add(customerDto);
    }
}
