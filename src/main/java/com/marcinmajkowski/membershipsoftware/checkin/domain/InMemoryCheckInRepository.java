package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

public class InMemoryCheckInRepository implements CheckInRepository {

    private final ConcurrentHashMap<Id, CheckIn> idToCheckIn = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Id, Set<CheckIn>> customerIdToCheckInSet = new ConcurrentHashMap<>();

    @Override
    public List<CheckIn> findByCustomer(Customer customer) {
        return new ArrayList<>(ofNullable(customerIdToCheckInSet.get(customer.getId())).orElse(emptySet()));
    }

    @Override
    public CheckIn findById(Id id) {
        return idToCheckIn.get(id);
    }

    @Override
    public CheckIn save(CheckIn checkIn) {
        requireNonNull(checkIn);
        idToCheckIn.put(checkIn.getId(), checkIn);
        customerIdToCheckInSet
                .computeIfAbsent(checkIn.getCustomerId(), this::createConcurrentHashSet)
                .add(checkIn);
        return checkIn;
    }

    private Set<CheckIn> createConcurrentHashSet(Id id) {
        return Collections.newSetFromMap(new ConcurrentHashMap<>());
    }
}
