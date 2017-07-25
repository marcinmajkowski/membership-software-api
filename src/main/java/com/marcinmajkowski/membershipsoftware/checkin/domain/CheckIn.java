package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.checkin.dto.CheckInDto;
import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

class CheckIn {

    private Id id;
    private LocalDateTime timestamp;
    private Customer customer;

    CheckIn(Id id, LocalDateTime timestamp, Customer customer) {
        this.id = Objects.requireNonNull(id);
        this.timestamp = Objects.requireNonNull(timestamp);
        this.customer = Objects.requireNonNull(customer);
    }

    Id getId() {
        return id;
    }

    Id getCustomerId() {
        return customer.getId();
    }

    CheckInDto toDto() {
        CheckInDto checkInDto = new CheckInDto();
        checkInDto.id = id.toString();
        checkInDto.timestamp = Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant());
        checkInDto.customerId = customer.getId().toString();
        return checkInDto;
    }
}
