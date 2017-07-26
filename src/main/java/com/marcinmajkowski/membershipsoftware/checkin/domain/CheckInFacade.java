package com.marcinmajkowski.membershipsoftware.checkin.domain;

import com.marcinmajkowski.membershipsoftware.checkin.dto.CheckInDto;
import com.marcinmajkowski.membershipsoftware.customer.domain.Customer;
import com.marcinmajkowski.membershipsoftware.customer.domain.InMemoryCustomerRepository;
import com.marcinmajkowski.membershipsoftware.shared.Id;

import java.util.List;
import java.util.stream.Collectors;

public class CheckInFacade {

    private final CheckInCreator checkInCreator;

    private final CheckInRepository checkInRepository;

    private final InMemoryCustomerRepository customerRepository;

    public CheckInFacade(CheckInCreator checkInCreator, CheckInRepository checkInRepository, InMemoryCustomerRepository customerRepository) {
        this.checkInCreator = checkInCreator;
        this.checkInRepository = checkInRepository;
        this.customerRepository = customerRepository;
    }

    public List<CheckInDto> findAllByCustomerId(String customerId) {
        Customer customer = customerRepository.findById(Id.fromString(customerId));
        return checkInRepository.findByCustomer(customer).stream()
                .map(CheckIn::toDto)
                // TODO sorted
                .collect(Collectors.toList());
    }

    public CheckInDto add(CheckInDto checkInDto) {
        CheckIn checkIn = checkInCreator.fromDto(checkInDto);
        checkIn = checkInRepository.save(checkIn);
        return checkIn.toDto();
    }

    public CheckInDto findById(String id) {
        return checkInRepository.findById(Id.fromString(id)).toDto();
    }
}
