package com.atchayaveeramani.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

@RestController
public class ExpenseController {

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {  
        return Arrays.asList(
            new Expense(1L, "Coffee", 2.50, LocalDate.now()),
            new Expense(2L, "Book", 15.00, LocalDate.now())
        );
    }
}
