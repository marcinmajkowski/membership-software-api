package com.marcinmajkowski.membershipsoftware.subscription;

import com.marcinmajkowski.membershipsoftware.shared.Controllers;
import com.marcinmajkowski.membershipsoftware.subscription.domain.SubscriptionFacade;
import com.marcinmajkowski.membershipsoftware.subscription.dto.SubscriptionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/subscriptions")
class SubscriptionController {

    private final SubscriptionFacade subscriptionFacade;

    SubscriptionController(SubscriptionFacade subscriptionFacade) {
        this.subscriptionFacade = subscriptionFacade;
    }

    @GetMapping("/{id}")
    SubscriptionDto findById(@PathVariable String id) {
        return subscriptionFacade.findById(id);
    }

    @GetMapping
    List<SubscriptionDto> findAllByCustomerId(@PathVariable String customerId) {
        return subscriptionFacade.findAllByCustomerId(customerId);
    }

    @PostMapping
    SubscriptionDto addSubscription(@PathVariable String customerId, @RequestBody SubscriptionDto subscriptionDto) {
        subscriptionDto.customerId = Controllers.requireEqualOrNull(customerId, subscriptionDto.customerId);;
        return subscriptionFacade.add(subscriptionDto);
    }
}
