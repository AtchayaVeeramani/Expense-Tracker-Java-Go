package com.atchayaveeramani.backend.service;

import com.atchayaveeramani.backend.dto.ExpenseDTO;
import com.atchayaveeramani.backend.model.Expense;
import com.atchayaveeramani.backend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    private ExpenseDTO toDTO(Expense e) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setAmount(e.getAmount());
        dto.setDate(e.getDate());
        return dto;
    }

    private Expense toEntity(ExpenseDTO dto) {
        return new Expense(dto.getId(), dto.getTitle(), dto.getAmount(), dto.getDate());
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense e = repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
        return toDTO(e);
    }

    @Override
    public ExpenseDTO addExpense(ExpenseDTO dto) {
        Expense entity = toEntity(dto);
        Expense saved = repo.save(entity);
        return toDTO(saved);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO dto) {
        Expense existing = repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
        existing.setTitle(dto.getTitle());
        existing.setAmount(dto.getAmount());
        existing.setDate(dto.getDate());
        Expense saved = repo.save(existing);
        return toDTO(saved);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense existing = repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
        repo.delete(existing);
    }
}
