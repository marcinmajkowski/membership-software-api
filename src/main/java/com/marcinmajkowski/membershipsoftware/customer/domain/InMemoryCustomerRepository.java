package com.marcinmajkowski.membershipsoftware.customer.domain;

import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

// TODO interface
public class InMemoryCustomerRepository {

    private final ConcurrentHashMap<Id, Customer> idToCustomer = new ConcurrentHashMap<>();

    List<Customer> findAll() {
        return new ArrayList<>(idToCustomer.values());
    }

    public Customer findById(Id id) {
        return idToCustomer.get(id);
    }

    void delete(Id id) {
        idToCustomer.remove(id);
    }

    Customer save(Customer customer) {
        Objects.requireNonNull(customer);
        idToCustomer.put(customer.getId(), customer);
        return customer;
    }
}
