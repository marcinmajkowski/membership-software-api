package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.subscription.dto.SubscriptionDto;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

abstract class Subscription {

    private Id id;
    // TODO enforce its set in a subclass
    protected SubscriptionType type;
    private LocalDateTime timestamp;
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimestamp;
    private Customer customer;

    // TODO builder
    Subscription(Id id, SubscriptionType type, LocalDateTime timestamp, LocalDateTime startTimestamp, LocalDateTime endTimestamp, Customer customer) {
        this.id = requireNonNull(id);
        this.type = requireNonNull(type);
        this.timestamp = requireNonNull(timestamp);
        this.startTimestamp = requireNonNull(startTimestamp);
        this.endTimestamp = requireNonNull(endTimestamp);
        this.customer = requireNonNull(customer);
    }

    Id getId() {
        return id;
    }

    Id getCustomerId() {
        return customer.getId();
    }

    abstract <T extends SubscriptionDto> T toDto();

    // TODO visitor
}
