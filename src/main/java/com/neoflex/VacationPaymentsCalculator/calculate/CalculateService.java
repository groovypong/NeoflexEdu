package com.neoflex.VacationPaymentsCalculator.calculate;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculateService {

    private static final String WORKING_DAYS = "22";

    static String replaceIfEmpty(String s) {
        return s == null || s.isEmpty() ? "0" : s;
    }

    public BigDecimal calculate(String salary, String days) {
        return new BigDecimal(replaceIfEmpty(salary))
                .divide(new BigDecimal(WORKING_DAYS), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(replaceIfEmpty(days)));
    }
}
