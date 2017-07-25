package com.marcinmajkowski.membershipsoftware;

import com.marcinmajkowski.membershipsoftware.checkin.domain.CheckInFacade;
import com.marcinmajkowski.membershipsoftware.checkin.dto.CheckInDto;
import com.marcinmajkowski.membershipsoftware.customer.domain.CustomerFacade;
import com.marcinmajkowski.membershipsoftware.customer.dto.CustomerDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Component
public class MembershipSoftwareApiCommandLineRunner implements CommandLineRunner {

    private final CheckInFacade checkInFacade;

    private final CustomerFacade customerFacade;

    public MembershipSoftwareApiCommandLineRunner(CheckInFacade checkInFacade, CustomerFacade customerFacade) {
        this.checkInFacade = checkInFacade;
        this.customerFacade = customerFacade;
    }

    @Override
    public void run(String... args) throws Exception {
        addCustomers();
        addCheckIns();
    }

    private void addCheckIns() {
        System.out.println("Adding check-ins");
        customerFacade.findAll().stream()
                .peek(customerDto -> System.out.println("- " + customerDto.firstName + " " + customerDto.lastName))
                .map(this::checkInOf)
                .flatMap(checkIn -> Stream.generate(() -> checkIn)
                        .limit(ThreadLocalRandom.current().nextInt(20)))
                .map(checkInFacade::add)
                .forEach(dto -> System.out.println("  - " + dto.timestamp + " (" + dto.id + ")"));
    }

    private CheckInDto checkInOf(CustomerDto customerDto) {
        CheckInDto checkInDto = new CheckInDto();
        checkInDto.customerId = customerDto.id;
        return checkInDto;
    }

    private void addCustomers() {
        System.out.println("Adding customers");
        Stream.of(
                customerOf("Marcin", "Kowalski"),
                customerOf("Sylwia", "Nowak")
        )
                .map(customerFacade::add)
                .forEach(dto -> System.out.println("- " + dto.firstName + " " + dto.lastName + " (" + dto.id + ")"));
    }

    private static CustomerDto customerOf(String firstName, String lastName) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.firstName = firstName;
        customerDto.lastName = lastName;
        return customerDto;
    }
}
