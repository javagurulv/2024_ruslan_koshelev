package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

class TravelCalculatePremiumServiceImplTest {


    String firstName = "John";
    String lastName = "Doe";
    Date dataFrom = new Date(2024, Calendar.JUNE, 12);
    Date dataTo = new Date(2024, Calendar.JUNE, 16);

    DateTimeService dateTimeService= new DateTimeService();

    TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl(dateTimeService);
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

    @Test
    public void requestAgreementPriceTest(){
        Assertions.assertEquals(new BigDecimal(4), response.getAgreementPrice());
    }

}