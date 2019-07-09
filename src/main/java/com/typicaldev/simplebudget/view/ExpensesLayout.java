package com.typicaldev.simplebudget.view;

import com.typicaldev.simplebudget.service.ExpenseService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExpensesLayout extends VerticalLayout {

    private ExpenseService expenseService;

    @Autowired
    public ExpensesLayout(final ExpenseService expenseService) {
        this.expenseService = expenseService;

        initView();
    }

    private void initView() {
        add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
    }
}