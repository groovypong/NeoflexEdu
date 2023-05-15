package com.neoflex.VacationPaymentsCalculator.calculate;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CalculateWithCalendarService extends CalculateService {

    static String replaceIfEmpty(String s) {
        return s == null || s.isEmpty() ? new Date().toString() : s;
    }

    private static String getVacationDaysCount(String vacationFrom, String vacationTo) {
        long vacationDays = TimeUnit.DAYS.convert(parseDate(vacationTo) - parseDate(vacationFrom), TimeUnit.MILLISECONDS);
        return Long.toString(++vacationDays);
    }

    private static long parseDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(date).getTime();
        } catch (ParseException parseException) {
            return 0L;
        }
    }

    public BigDecimal calculate(String salary, String vacationFrom, String vacationTo) {
        return calculate(salary, getVacationDaysCount(replaceIfEmpty(vacationFrom), replaceIfEmpty(vacationTo)));
    }
}
