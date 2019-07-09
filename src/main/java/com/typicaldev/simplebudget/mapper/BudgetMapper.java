package com.typicaldev.simplebudget.mapper;

import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.dto.BudgetResponseDto;
import com.typicaldev.simplebudget.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = ExpenseMapper.class)
public abstract class BudgetMapper {

    public Budget toDomain(final BudgetCreateDto dto) {
        final Budget budget = toBaseDomain(dto);

        budget.setCreated(Instant.now());

        return budget;
    }

    public abstract BudgetResponseDto toDto(final Budget budget);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    abstract Budget toBaseDomain(final BudgetCreateDto dto);
}