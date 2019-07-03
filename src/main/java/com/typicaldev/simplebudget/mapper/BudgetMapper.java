package com.typicaldev.simplebudget.mapper;

import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.model.Budget;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper {

    public Budget toDomain(final BudgetCreateDto dto) {
        Budget budget = new Budget();
        return budget;
    }
}