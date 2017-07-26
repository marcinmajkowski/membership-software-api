package com.marcinmajkowski.membershipsoftware.subscription.dto;

import java.util.Date;

public abstract class SubscriptionDto {

    public String id;
    public SubscriptionTypeDto type;
    public Date timestamp;
    public Date startTimestamp;
    public Date endTimestamp;
    public String customerId;
}
