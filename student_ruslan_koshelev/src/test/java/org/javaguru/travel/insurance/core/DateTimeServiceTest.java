package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


class DateTimeServiceTest {

    Date dateFrom;
    Date dateTo;
    @BeforeEach
    public void preparingForTest(){
        dateFrom = new Date(2024, Calendar.DECEMBER, 6);
        dateTo= new Date(2024, Calendar.DECEMBER, 16);


    }
    @Test
    public void daysBetweenTwoDatesCalculateTest(){
        DateTimeService dateTimeService = new DateTimeService(dateFrom,dateTo);
        Assertions.assertEquals(new BigDecimal(10), dateTimeService.getAgreementPrice());
    }

}