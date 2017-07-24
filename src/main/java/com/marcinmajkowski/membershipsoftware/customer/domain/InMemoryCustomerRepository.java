package com.marcinmajkowski.membershipsoftware.customer.domain;

import com.marcinmajkowski.membershipsoftware.shared.FirstName;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.shared.LastName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

class InMemoryCustomerRepository {

    private final ConcurrentHashMap<Id, Customer> idToCustomer = new ConcurrentHashMap<>();

    InMemoryCustomerRepository() {
        Stream.of(
                new Customer(new Id(UUID.randomUUID()), new FirstName("Marcin"), new LastName("Kowalski")),
                new Customer(new Id(UUID.randomUUID()), new FirstName("Sylwia"), new LastName("Nowak"))
        )
                .forEach(customer -> idToCustomer.put(customer.getId(), customer));
    }

    List<Customer> findAll() {
        return new ArrayList<>(idToCustomer.values());
    }

    Customer findById(Id id) {
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
