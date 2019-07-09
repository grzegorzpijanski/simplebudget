package com.typicaldev.simplebudget.repository;

import com.typicaldev.simplebudget.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> { }