package com.marcinmajkowski.membershipsoftware.checkin;

import com.marcinmajkowski.membershipsoftware.checkin.domain.CheckInFacade;
import com.marcinmajkowski.membershipsoftware.checkin.dto.CheckInDto;
import com.marcinmajkowski.membershipsoftware.shared.Controllers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/check-ins")
class CheckInController {

    private final CheckInFacade checkInFacade;

    CheckInController(CheckInFacade checkInFacade) {
        this.checkInFacade = checkInFacade;
    }

    @GetMapping("/{id}")
    CheckInDto findById(@PathVariable String id) {
        return checkInFacade.findById(id);
    }

    @GetMapping
    List<CheckInDto> findAllByCustomerId(@PathVariable String customerId) {
        return checkInFacade.findAllByCustomerId(customerId);
    }

    @PostMapping
    CheckInDto addCheckIn(@PathVariable String customerId, @RequestBody CheckInDto checkInDto) {
        checkInDto.customerId = Controllers.requireEqualOrNull(customerId, checkInDto.customerId);
        return checkInFacade.add(checkInDto);
    }
}
