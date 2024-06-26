package org.javaguru.travel.insurance.core.validations.person;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import org.javaguru.travel.insurance.core.api.dto.PersonDTO;
import org.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import org.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class EmptyMedicalRiskLimitLevelValidation extends TravelPersonFieldValidationImpl {

    @Value( "${medical.risk.limit.level.enabled:false}" )
    private Boolean medicalRiskLimitLevelEnabled;

    private final ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO agreement, PersonDTO person) {
        return (isMedicalRiskLimitLevelEnabled()
                    && containsTravelMedical(agreement)
                    && isMedicalRiskLimitLevelIsNullOrBlank(person))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_13"))
                : Optional.empty();
    }

    private boolean isMedicalRiskLimitLevelEnabled() {
        return medicalRiskLimitLevelEnabled;
    }

    private boolean containsTravelMedical(AgreementDTO agreement) {
        return agreement.getSelectedRisks() != null
                && agreement.getSelectedRisks().contains("TRAVEL_MEDICAL");
    }

    private boolean isMedicalRiskLimitLevelIsNullOrBlank(PersonDTO person) {
        return person.getMedicalRiskLimitLevel() == null || person.getMedicalRiskLimitLevel().isBlank();
    }

}
