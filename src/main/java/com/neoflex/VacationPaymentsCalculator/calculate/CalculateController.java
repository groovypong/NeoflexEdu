package com.neoflex.VacationPaymentsCalculator.calculate;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    CalculateService calculateService = new CalculateService();

    @GetMapping("/calculate")
    public String calculator(
            Model model,
            @Nullable @RequestParam String salary,
            @Nullable @RequestParam String days
    ) {
        model.addAttribute("payments", calculateService.calculate(salary, days));
        return "calculator";
    }
}