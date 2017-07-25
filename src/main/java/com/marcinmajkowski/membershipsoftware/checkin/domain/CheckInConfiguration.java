package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.InMemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CheckInConfiguration {

    @Bean
    CheckInFacade checkInFacade(InMemoryCustomerRepository inMemoryCustomerRepository) {
        return new CheckInFacade(new CheckInCreator(inMemoryCustomerRepository), new InMemoryCheckInRepository(), inMemoryCustomerRepository);
    }
}
