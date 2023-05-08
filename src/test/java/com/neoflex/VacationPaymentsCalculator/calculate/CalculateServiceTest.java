package com.neoflex.VacationPaymentsCalculator.calculate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    private final CalculateService calculateService = new CalculateService();

    @Test
    public void calculateShouldReturnBigDecimalResult() {
        String salary = "25";
        String vacationDays = "1";
        String expectedResult = "1.14";

        assertEquals(new BigDecimal(expectedResult), calculateService.calculate(salary, vacationDays));
    }
}
