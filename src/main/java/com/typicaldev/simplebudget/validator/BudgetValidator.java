package com.typicaldev.simplebudget.validator;

import java.util.Optional;
import java.util.UUID;

import com.typicaldev.simplebudget.model.Budget;
import com.typicaldev.simplebudget.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetValidator {

    private BudgetRepository budgetRepository;

    @Autowired
    public BudgetValidator(final BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public boolean delete(final UUID id) {
        final Optional<Budget> budget = budgetRepository.findById(id);

        return budget.isPresent();
    }
}