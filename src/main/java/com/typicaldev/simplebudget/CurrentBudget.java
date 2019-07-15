package com.typicaldev.simplebudget;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Setter
@Getter
@Component
@Scope("singleton")
public class CurrentBudget {

    private UUID budgetId;

    public CurrentBudget() { }

}