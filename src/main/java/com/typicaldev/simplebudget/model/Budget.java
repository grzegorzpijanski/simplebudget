package com.typicaldev.simplebudget.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity(name = "budget")
@Data
@EqualsAndHashCode(exclude = "expenses")
@ToString(exclude = "expenses")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Instant created;

    @Column
    private double value;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Expense> expenses;
}