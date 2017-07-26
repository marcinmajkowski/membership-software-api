package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.customer.domain.InMemoryCustomerRepository;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.subscription.dto.SubscriptionDto;

import java.util.List;

public class SubscriptionFacade {

    private final InMemoryCustomerRepository customerRepository;
    
    SubscriptionFacade(InMemoryCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<SubscriptionDto> findAllByCustomerId(String customerId) {
        Customer customer = customerRepository.findById(Id.fromString(customerId));
        // TODO
        return null;
    }

    public SubscriptionDto add(SubscriptionDto subscriptionDto) {
        // TODO
        return null;
    }

    public SubscriptionDto findById(String id) {
        // TODO
        return null;
    }
}
