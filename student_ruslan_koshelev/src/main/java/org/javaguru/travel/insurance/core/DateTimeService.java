package org.javaguru.travel.insurance.core;

import java.math.BigDecimal;
import java.util.Date;

public class DateTimeService {
    private Date dateFrom;
    private Date dateTo;
    private BigDecimal agreementPrice;

    public DateTimeService() {
    }

    public DateTimeService(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.agreementPrice = daysBetweenTwoDates(dateFrom,dateTo);
    }

    public BigDecimal getAgreementPrice() {
        return agreementPrice;
    }

    private BigDecimal daysBetweenTwoDates(Date dateFrom, Date dateTo) {
        long millisBetweenDates = dateTo.getTime() - dateFrom.getTime();
        return trasferMillisToDates(millisBetweenDates);
    }

    private BigDecimal trasferMillisToDates(long millis) {
        final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;
        return (new BigDecimal(millis / MILLIS_IN_DAY));
    }
}
