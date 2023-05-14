package com.neoflex.VacationPaymentsCalculator.calculate;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CalculateByCalendarService extends CalculateService {

    static String isPresent(String s) {
        return s == null || s.isEmpty() ? s = new Date().toString() : s;
    }

    private static String getVacationDaysCount(String vacationFrom, String vacationTo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long vacationDays = 0;

        try {
            Date from = dateFormat.parse(vacationFrom);
            Date to = dateFormat.parse(vacationTo);
            vacationDays = TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        return Long.toString(++vacationDays);
    }

    public BigDecimal calculate(String salary, String vacationFrom, String vacationTo) {
        return calculate(salary, getVacationDaysCount(isPresent(vacationFrom), isPresent(vacationTo)));
    }
}
