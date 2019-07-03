package com.typicaldev.simplebudget.repository;

import com.typicaldev.simplebudget.model.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BudgetRepository extends CrudRepository<Budget, UUID> { }