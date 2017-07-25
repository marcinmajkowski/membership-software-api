package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.checkin.dto.CheckInDto;
import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.customer.domain.InMemoryCustomerRepository;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.util.Optional.ofNullable;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

class CheckInCreator {

    private final InMemoryCustomerRepository customerRepository;

    CheckInCreator(InMemoryCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    CheckIn fromDto(CheckInDto checkInDto) {
        Id id = new Id(randomUUID());
        LocalDateTime timestamp = ofNullable(checkInDto.timestamp)
                .map(this::localDateTimeFrom)
                .orElseGet(LocalDateTime::now);
        Customer customer = customerRepository.findById(new Id(fromString(checkInDto.customerId)));
        return new CheckIn(id, timestamp, customer);
    }

    private LocalDateTime localDateTimeFrom(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
