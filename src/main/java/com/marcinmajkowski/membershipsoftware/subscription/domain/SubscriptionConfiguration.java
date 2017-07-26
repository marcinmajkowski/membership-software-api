package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.InMemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubscriptionConfiguration {

    @Bean
    public SubscriptionFacade subscriptionFacade(InMemoryCustomerRepository customerRepository) {
        return new SubscriptionFacade(customerRepository);
    }
}
