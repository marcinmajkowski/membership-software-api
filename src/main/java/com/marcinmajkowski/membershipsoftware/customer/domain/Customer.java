package com.marcinmajkowski.membershipsoftware.customer.domain;

import com.marcinmajkowski.membershipsoftware.customer.dto.CustomerDto;
import com.marcinmajkowski.membershipsoftware.shared.FirstName;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.shared.LastName;

import java.util.Objects;

public class Customer {

    private Id id;
    private FirstName firstName;
    private LastName lastName;

    Customer(Id id, FirstName firstName, LastName lastName) {
        this.id = Objects.requireNonNull(id);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

    public Id getId() {
        return id;
    }

    CustomerDto toDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.id = id.toString();
        customerDto.firstName = firstName.toString();
        customerDto.lastName = lastName.toString();
        return customerDto;
    }
}
