package com.typicaldev.simplebudget.service;

import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.dto.BudgetResponseDto;
import com.typicaldev.simplebudget.mapper.BudgetMapper;
import com.typicaldev.simplebudget.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private BudgetRepository budgetRepository;

    private BudgetMapper budgetMapper;

    @Autowired
    public BudgetService(final BudgetRepository budgetRepository,
                         final BudgetMapper budgetMapper) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
    }

    public void addBudget(final BudgetCreateDto dto) {
        final var budget = budgetMapper.toDomain(dto);

        budgetRepository.save(budget);
    }

    public List<BudgetResponseDto> getBudgets()
}