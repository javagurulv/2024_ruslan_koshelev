package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

class TravelCalculatePremiumServiceImplTest {


    String firstName = "John";
    String lastName = "Doe";
    Date dataFrom = new Date(2024, Calendar.JUNE, 12);
    Date dataTo = new Date(2025, Calendar.JUNE, 12);

    TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
    TravelCalculatePremiumResponse response;
    TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(firstName, lastName, dataFrom, dataTo);

    @BeforeEach
    public void requestResponsePrepare() {
        response = service.calculatePremium(request);
    }

    @Test
    public void requestResponseFirstNameTest() {

        Assertions.assertEquals(firstName, response.getPersonFirstName());
    }

    @Test
    public void requestResponseLastNameTest() {
        Assertions.assertEquals(lastName, response.getPersonLastName());
    }

    @Test
    public void requestResponseDataFromTest() {
        Assertions.assertEquals(dataFrom, response.getAgreementDateFrom());
    }

    @Test
    public void requestResponseDataToTest() {
        Assertions.assertEquals(dataTo, response.getAgreementDateTo());
    }

    @Test
    public void deleteMe() {

    }

}