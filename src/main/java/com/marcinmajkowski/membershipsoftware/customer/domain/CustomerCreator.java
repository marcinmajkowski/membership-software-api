package com.marcinmajkowski.membershipsoftware.customer.domain;

import com.marcinmajkowski.membershipsoftware.customer.dto.CustomerDto;
import com.marcinmajkowski.membershipsoftware.shared.FirstName;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.shared.LastName;

class CustomerCreator {

    Customer fromDto(CustomerDto customerDto) {
        Id id = new Id();
        FirstName firstName = new FirstName(customerDto.firstName);
        LastName lastName = new LastName(customerDto.lastName);
        return new Customer(id, firstName, lastName);
    }
}
