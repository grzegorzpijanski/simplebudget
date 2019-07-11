package com.typicaldev.simplebudget.view;

import com.typicaldev.simplebudget.dto.ExpenseResponseDto;
import com.typicaldev.simplebudget.model.Expense;
import com.typicaldev.simplebudget.service.ExpenseService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@SpringComponent
@UIScope
public class ExpensesLayout extends VerticalLayout {

    private ExpenseService expenseService;

    private Grid<ExpenseResponseDto> expensesGrid;

    @Autowired
    public ExpensesLayout(final ExpenseService expenseService) {
        this.expenseService = expenseService;

        initView();
        initGrid();
    }

    private void initView() {
        add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
    }

    private void initGrid() {
        final var expenses = expenseService.getExpenses();

        expensesGrid = new Grid<>(ExpenseResponseDto.class, true);
        expensesGrid.setItems(expenses);

        add(expensesGrid);
    }
}