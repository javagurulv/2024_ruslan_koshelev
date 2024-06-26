package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {

        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementPrice(daysBetweenTwoDates(response.getAgreementDateFrom(),response.getAgreementDateTo()));

        return response;
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
