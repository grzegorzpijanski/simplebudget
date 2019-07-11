package com.typicaldev.simplebudget.mapper;

import com.typicaldev.simplebudget.dto.ExpenseCreateDto;
import com.typicaldev.simplebudget.dto.ExpenseResponseDto;
import com.typicaldev.simplebudget.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BudgetMapper.class)
public interface ExpenseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "budget", ignore = true)
    Expense toDomain(final ExpenseCreateDto dto);


    ExpenseResponseDto toDto(final Expense expense);
}