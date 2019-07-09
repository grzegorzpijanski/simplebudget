package com.typicaldev.simplebudget.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity(name = "expense")
@Data
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column
    private String name;

    @Column
    private double plannedValue;

    @Column
    private double realValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budgetId", nullable = false)
    @JsonIgnore
    private Budget budget;

    public Expense(final String name, final double plannedValue, final double realValue) {
        this.name = name;
        this.plannedValue = plannedValue;
        this.realValue = realValue;
    }
}