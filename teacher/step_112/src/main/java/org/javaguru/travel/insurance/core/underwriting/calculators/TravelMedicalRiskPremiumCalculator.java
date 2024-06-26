package org.javaguru.travel.insurance.core.underwriting.calculators;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.core.domain.CountryDefaultDayRate;
import org.javaguru.travel.insurance.core.repositories.CountryDefaultDayRateRepository;
import org.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import org.javaguru.travel.insurance.core.util.DateTimeUtil;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelMedicalRiskPremiumCalculator implements TravelRiskPremiumCalculator {

    private final DateTimeUtil dateTimeUtil;
    private final CountryDefaultDayRateRepository countryDefaultDayRateRepository;

    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        var daysCount = calculateDayCount(request);
        var countryDefaultRate = findCountryDefaultDayRate(request);
        return countryDefaultRate.multiply(daysCount)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDayCount(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeUtil.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return new BigDecimal(daysBetween);
    }

    private BigDecimal findCountryDefaultDayRate(TravelCalculatePremiumRequest request) {
        return countryDefaultDayRateRepository.findByCountryIc(request.getCountry())
                .map(CountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + request.getCountry()));
    }

    @Override
    public String getRiskIc() {
        return "TRAVEL_MEDICAL";
    }

}
