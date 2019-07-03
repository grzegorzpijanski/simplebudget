package com.typicaldev.simplebudget.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
public final class ExpenseCreateDto {

    @NotBlank
    private String name;

    @Min(0)
    private double realValue;

    @Min(0)
    private double plannedValue;
}