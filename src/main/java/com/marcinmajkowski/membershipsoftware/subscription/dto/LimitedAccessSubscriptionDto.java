package com.marcinmajkowski.membershipsoftware.subscription.dto;

public class LimitedAccessSubscriptionDto extends SubscriptionDto {

    public final SubscriptionTypeDto type = SubscriptionTypeDto.LIMITED_ACCESS;
    public int checkInsMaximum;
}
