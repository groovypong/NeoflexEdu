package com.neoflex.VacationPaymentsCalculator.calculate;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    private final CalculateWithCalendarService calculateWithCalendarService;

    public CalculateController(
            CalculateWithCalendarService calculateWithCalendarService
    ) {
        this.calculateWithCalendarService = calculateWithCalendarService;
    }

    @GetMapping("/calculate")
    public String calculator(
            Model model,
            @Nullable @RequestParam String salary,
            @Nullable @RequestParam String days,
            @Nullable @RequestParam String salaryByCalendar,
            @Nullable @RequestParam String vacationFrom,
            @Nullable @RequestParam String vacationTo
    ) {
        model.addAttribute(
                "payments",
                salary != null
                        ? calculateWithCalendarService.calculate(salary, days)
                        : calculateWithCalendarService.calculate(salaryByCalendar, vacationFrom, vacationTo)
        );

        return "calculator";
    }
}
