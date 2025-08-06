package com.atchayaveeramani.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    // GET /expenses - fetch all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // POST /expenses - add new expense
   @PostMapping
public Expense addExpense(@Valid @RequestBody Expense expense) {
    if (expense.getDate() == null) {
        expense.setDate(LocalDate.now());
    }
    return expenseRepository.save(expense);
}


@PutMapping("/{id}")
public Expense updateExpense(@PathVariable Long id, @Valid @RequestBody Expense expenseDetails) {
    Expense expense = expenseRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));

    expense.setTitle(expenseDetails.getTitle());
    expense.setAmount(expenseDetails.getAmount());
    expense.setDate(expenseDetails.getDate() != null ? expenseDetails.getDate() : expense.getDate());

    return expenseRepository.save(expense);
}


    // GET /expenses/{id} - get expense by id
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
    }

   

    // DELETE /expenses/{id} - delete expense
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
        expenseRepository.delete(expense);
    }
}
