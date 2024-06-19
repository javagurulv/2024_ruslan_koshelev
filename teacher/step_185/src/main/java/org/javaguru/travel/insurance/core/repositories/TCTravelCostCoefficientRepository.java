package org.javaguru.travel.insurance.core.repositories;

import org.javaguru.travel.insurance.core.domain.TCTravelCostCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface TCTravelCostCoefficientRepository
        extends JpaRepository<TCTravelCostCoefficient, Long> {

    @Query("SELECT tc from TCTravelCostCoefficient tc " +
            "where tc.travelCostFrom <= :travelCost " +
            "and tc.travelCostTo >= :travelCost")
    Optional<TCTravelCostCoefficient> findCoefficient(@Param("travelCost") BigDecimal travelCost);

}
