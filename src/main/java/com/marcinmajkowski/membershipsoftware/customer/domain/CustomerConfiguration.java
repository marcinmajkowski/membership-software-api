package com.marcinmajkowski.membershipsoftware.customer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomerConfiguration {

    @Bean
    InMemoryCustomerRepository inMemoryCustomerRepository() {
        return new InMemoryCustomerRepository();
    }

    @Bean
    CustomerFacade customerFacade(InMemoryCustomerRepository inMemoryCustomerRepository) {
        return new CustomerFacade(new CustomerCreator(), inMemoryCustomerRepository);
    }
}
