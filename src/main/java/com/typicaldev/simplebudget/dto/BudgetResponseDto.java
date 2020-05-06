package com.typicaldev.simplebudget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class BudgetResponseDto {

    private double value;

    private Instant created;

    private List<ExpenseResponseDto> expenses;
}