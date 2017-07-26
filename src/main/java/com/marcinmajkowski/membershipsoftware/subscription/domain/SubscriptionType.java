package com.marcinmajkowski.membershipsoftware.subscription.domain;

import com.marcinmajkowski.membershipsoftware.subscription.dto.SubscriptionTypeDto;

enum SubscriptionType {
    UNLIMITED_ACCESS, LIMITED_ACCESS;

    SubscriptionTypeDto toDto() {
        return SubscriptionTypeDto.valueOf(name());
    }
}
