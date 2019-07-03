package com.typicaldev.simplebudget.dto;

import lombok.AllArgsConstructor;
import javax.validation.constraints.Min;

@AllArgsConstructor
public final class BudgetCreateDto {

    @Min(0)
    private double value;
}