package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.shared.Id;
import com.marcinmajkowski.membershipsoftware.subscription.dto.LimitedAccessSubscriptionDto;

import java.time.LocalDateTime;

class LimitedAccessSubscription extends Subscription {

    private final SubscriptionType type = SubscriptionType.LIMITED_ACCESS;
    private int checkInsMaximum;

    LimitedAccessSubscription(Id id, SubscriptionType type, LocalDateTime timestamp, LocalDateTime startTimestamp, LocalDateTime endTimestamp, Customer customer, int checkInsMaximum) {
        super(id, type, timestamp, startTimestamp, endTimestamp, customer);
        this.checkInsMaximum = checkInsMaximum;
    }

    @Override
    LimitedAccessSubscriptionDto toDto() {
        // TODO
        return null;
    }
}
