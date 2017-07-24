package com.marcinmajkowski.membershipsoftware.customer.domain;

import com.marcinmajkowski.membershipsoftware.customer.dto.CustomerDto;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerFacade {

    private final CustomerCreator customerCreator;

    private final InMemoryCustomerRepository customerRepository;

    CustomerFacade(CustomerCreator customerCreator, InMemoryCustomerRepository customerRepository) {
        this.customerCreator = customerCreator;
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(Customer::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto findById(String id) {
        return customerRepository.findById(new Id(UUID.fromString(id))).toDto();
    }

    public CustomerDto add(CustomerDto customerDto) {
        Customer customer = customerCreator.fromDto(customerDto);
        customer = customerRepository.save(customer);
        return customer.toDto();
    }
}
