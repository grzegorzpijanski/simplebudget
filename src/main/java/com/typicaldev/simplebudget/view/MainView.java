package com.typicaldev.simplebudget.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Route(value = "simplebudget")
public class MainView extends VerticalLayout {

    private ExpensesLayout expensesLayout;

    private String applicationName;

    private Label applicationTitle = new Label();

    public MainView(final @Value("${spring.application.name}") String applicationName,
                    final ExpensesLayout expensesLayout) {
        this.applicationName = applicationName;
        this.expensesLayout = expensesLayout;

        initToolbar();
        addExpensesLayout();
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
}