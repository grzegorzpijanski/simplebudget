package com.typicaldev.simplebudget.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public final class ExpenseResponseDto {

    private String name;

    private double realValue;

    private double plannedValue;
}