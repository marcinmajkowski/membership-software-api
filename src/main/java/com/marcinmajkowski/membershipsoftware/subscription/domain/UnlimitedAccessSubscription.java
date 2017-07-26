package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.subscription.dto.UnlimitedAccessSubscriptionDto;

import java.time.LocalDateTime;

class UnlimitedAccessSubscription extends Subscription {

    private final SubscriptionType type = SubscriptionType.UNLIMITED_ACCESS;

    UnlimitedAccessSubscription(Id id, SubscriptionType type, LocalDateTime timestamp, LocalDateTime startTimestamp, LocalDateTime endTimestamp, Customer customer) {
        super(id, type, timestamp, startTimestamp, endTimestamp, customer);
    }

    @Override
    UnlimitedAccessSubscriptionDto toDto() {
        // TODO
        return null;
    }
}
