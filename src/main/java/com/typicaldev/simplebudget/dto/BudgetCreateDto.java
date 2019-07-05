package com.typicaldev.simplebudget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
public final class BudgetCreateDto {

    @Min(0)
    private double value;
}