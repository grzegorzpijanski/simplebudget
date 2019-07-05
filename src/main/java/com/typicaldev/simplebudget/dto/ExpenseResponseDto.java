package com.typicaldev.simplebudget.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public final class ExpenseResponseDto {

    private String name;

    private double realValue;

    private double plannedValue;
}