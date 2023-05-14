package com.neoflex.VacationPaymentsCalculator.calculate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    private final CalculateService calculateService = new CalculateService();

    @Test
    public void calculateShouldReturnResult() {
        String salary = "25";
        String vacationDays = "2";
        String expectedResult = "2.28";

        assertEquals(new BigDecimal(expectedResult), calculateService.calculate(salary, vacationDays));
    }
}
