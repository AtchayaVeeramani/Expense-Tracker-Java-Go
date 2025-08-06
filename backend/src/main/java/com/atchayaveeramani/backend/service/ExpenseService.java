package com.atchayaveeramani.backend.service;

import com.atchayaveeramani.backend.dto.ExpenseDTO;
import java.util.List;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    ExpenseDTO addExpense(ExpenseDTO dto);
    ExpenseDTO updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);
}
