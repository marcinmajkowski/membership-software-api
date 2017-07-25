package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.util.List;

interface CheckInRepository {

    List<CheckIn> findByCustomer(Customer customer);

    CheckIn findById(Id id);

    CheckIn save(CheckIn checkIn);
}
