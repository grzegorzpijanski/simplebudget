package com.typicaldev.simplebudget.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Instant created;

    @Column
    private double value;
}