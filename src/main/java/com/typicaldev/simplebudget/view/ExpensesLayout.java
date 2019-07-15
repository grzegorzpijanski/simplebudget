package com.typicaldev.simplebudget.view;

import com.google.common.eventbus.Subscribe;
import com.typicaldev.simplebudget.dto.ExpenseCreateDto;
import com.typicaldev.simplebudget.dto.ExpenseResponseDto;
import com.typicaldev.simplebudget.event.Bus;
import com.typicaldev.simplebudget.event.CreateExpenseEvent;
import com.typicaldev.simplebudget.form.CreateExpenseForm;
import com.typicaldev.simplebudget.service.ExpenseService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class ExpensesLayout extends VerticalLayout implements Bus.Passenger {

    private ExpenseService expenseService;

    private CreateExpenseForm createExpenseForm;

    private Bus bus;

    private Grid<ExpenseResponseDto> expensesGrid;

    private Button createExpenseButton = new Button("Add new expense");

    @Autowired
    public ExpensesLayout(final ExpenseService expenseService,
                          final CreateExpenseForm createExpenseForm,
                          final Bus bus) {
        this.expenseService = expenseService;
        this.createExpenseForm = createExpenseForm;
        this.bus = bus;

        bus.getIn(this);

        initView();
        initGrid();

        createExpenseForm.setExpense(null);
    }

    private void initView() {
        initGrid();
        initCreateExpenseButton();

        add(createExpenseButton);

        final HorizontalLayout mainContent = new HorizontalLayout(expensesGrid, createExpenseForm);

        mainContent.setWidthFull();
        add(mainContent);

    }

    private void initGrid() {
        final var expenses = expenseService.getExpenses();

        expensesGrid = new Grid<>(ExpenseResponseDto.class, true);
        expensesGrid.setItems(expenses);

        expensesGrid.asSingleSelect().addValueChangeListener(event -> {
            final var expenseResultDto = expensesGrid.asSingleSelect().getValue();
            final var expenseCreateDto = expenseService.getCreateDto(expenseResultDto);
            createExpenseForm.setExpense(expenseCreateDto);
        });
    }

    private void initCreateExpenseButton() {
        createExpenseButton.addClickListener(event -> {
            expensesGrid.asSingleSelect().clear();
            createExpenseForm.setExpense(new ExpenseCreateDto());
        });
    }

    private void updateExpenses() {
        expensesGrid.setItems(expenseService.getExpenses());
    }

    @Subscribe
    public void onEvent(final CreateExpenseEvent event) {
        updateExpenses();
    }
}