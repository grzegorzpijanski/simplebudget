package com.typicaldev.simplebudget.dto;

import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public final class ExpenseResponseDto {

    private String name;

    private double realValue;

    private double plannedValue;
}