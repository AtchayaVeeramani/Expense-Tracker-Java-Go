package com.atchayaveeramani.backend.repository;

import com.atchayaveeramani.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {}
