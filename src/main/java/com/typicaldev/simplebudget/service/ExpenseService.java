package com.typicaldev.simplebudget.service;

import com.typicaldev.simplebudget.dto.ExpenseCreateDto;
import com.typicaldev.simplebudget.dto.ExpenseResponseDto;
import com.typicaldev.simplebudget.mapper.ExpenseMapper;
import com.typicaldev.simplebudget.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    private ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseService(final ExpenseRepository expenseRepository,
                          final ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public void addExpense(final ExpenseCreateDto dto) {
        final var expense = expenseMapper.toDomain(dto);

        expenseRepository.save(expense);
    }

    public void deleteExpense(final UUID id) {
        expenseRepository.deleteById(id);
    }

    public void updateExpense(final ExpenseCreateDto dto) {
        addExpense(dto);
    }

    public List<ExpenseResponseDto> getExpenses() {
        final var expenses = expenseRepository.findAll();

        return StreamSupport
                .stream(expenses.spliterator(), false)
                .map(expenseMapper::toDto)
                .collect(toList());
    }
}