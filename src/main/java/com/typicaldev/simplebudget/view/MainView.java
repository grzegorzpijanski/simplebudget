package com.typicaldev.simplebudget.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Value;

@Route(value = "simplebudget")
public class MainView extends VerticalLayout {

    private ExpensesLayout expensesLayout;

    private BudgetLayout budgetLayout;

    private String applicationName;

    private Label applicationTitle = new Label();

    public MainView(final @Value("${spring.application.name}") String applicationName,
                    final ExpensesLayout expensesLayout,
                    final BudgetLayout budgetLayout) {
        this.applicationName = applicationName;
        this.expensesLayout = expensesLayout;
        this.budgetLayout = budgetLayout;

        initToolbar();
        addExpensesLayout();
        addBudgetLayout();
    }

    private void initToolbar() {
        initTitle();
        add(applicationTitle);
    }

    private void initTitle() {
        applicationTitle.setText(applicationName);
    }

    private void addExpensesLayout() {
        add(expensesLayout);
    }

    private void addBudgetLayout() {
        add(budgetLayout);
    }
}