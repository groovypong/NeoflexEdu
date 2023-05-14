package com.neoflex.VacationPaymentsCalculator.calculate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateByCalendarServiceTest {

    private final CalculateByCalendarService calculateByCalendarService = new CalculateByCalendarService();

    @Test
    public void calculateShouldReturnResult() {
        String salary = "25";
        String vacationFrom = "2023-03-01";
        String vacationTo = "2023-03-02";
        String expectedResult = "2.28";

        assertEquals(new BigDecimal(expectedResult), calculateByCalendarService.calculate(salary,vacationFrom, vacationTo));
    }

}
