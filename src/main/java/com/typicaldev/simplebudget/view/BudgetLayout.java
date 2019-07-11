package com.typicaldev.simplebudget.view;

import com.typicaldev.simplebudget.service.BudgetService;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class BudgetLayout extends VerticalLayout {

    private BudgetService budgetService;

    private Label budgetLabel = new Label();

    @Autowired
    public BudgetLayout(final BudgetService budgetService) {
        this.budgetService = budgetService;

        initLabel();
    }

    private void initLabel() {
        final var budget = budgetService.getLatestBudget();

        budgetLabel.setText(String.valueOf(budget.getValue()));

        add(budgetLabel);
    }
}