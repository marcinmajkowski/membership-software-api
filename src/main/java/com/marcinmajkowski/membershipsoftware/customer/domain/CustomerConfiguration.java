package com.marcinmajkowski.membershipsoftware.customer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomerConfiguration {

    @Bean
    CustomerFacade customerFacade() {
        return new CustomerFacade(new CustomerCreator(), new InMemoryCustomerRepository());
    }
}
