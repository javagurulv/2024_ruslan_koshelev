package org.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
class DateTimeService {

    public BigDecimal calculateAgreementPrice(Date dateFrom, Date dateTo) {
        long millisBetweenDates = dateTo.getTime() - dateFrom.getTime();
        return trasferMillisToDates(millisBetweenDates);
    }

    private BigDecimal trasferMillisToDates(long millis) {
        final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;
        return (new BigDecimal(millis / MILLIS_IN_DAY));
    }
}
