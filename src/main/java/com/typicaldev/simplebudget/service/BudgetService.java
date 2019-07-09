package com.typicaldev.simplebudget.service;

import javax.naming.OperationNotSupportedException;

import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.dto.BudgetResponseDto;
import com.typicaldev.simplebudget.mapper.BudgetMapper;
import com.typicaldev.simplebudget.repository.BudgetRepository;
import com.typicaldev.simplebudget.validator.BudgetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class BudgetService {

    private BudgetRepository budgetRepository;

    private BudgetMapper budgetMapper;

    private BudgetValidator budgetValidator;

    @Autowired
    public BudgetService(final BudgetRepository budgetRepository,
                         final BudgetMapper budgetMapper,
                         final BudgetValidator budgetValidator) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
        this.budgetValidator = budgetValidator;
    }

    public void addBudget(final BudgetCreateDto dto) {
        final var budget = budgetMapper.toDomain(dto);

        budgetRepository.save(budget);
    }

    public List<BudgetResponseDto> getBudgets(){
        final var budgets = budgetRepository.findAll();

        return budgets.stream()
                .map(budget -> budgetMapper.toDto(budget))
                .collect(toList());
    }

    public void deleteBudget(final UUID budgetId) throws OperationNotSupportedException {
        if (budgetValidator.delete(budgetId)) {
            budgetRepository.deleteById(budgetId);
        } else throw new OperationNotSupportedException(
                "Unable to delete budget, because it contains expenses");
    }
}