package com.typicaldev.simplebudget.repository;

import com.typicaldev.simplebudget.model.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExpenseRepository extends CrudRepository<Expense, UUID> { }