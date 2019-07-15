package com.typicaldev.simplebudget.view;

import com.google.common.eventbus.Subscribe;
import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.event.Bus;
import com.typicaldev.simplebudget.event.CreateBudgetEvent;
import com.typicaldev.simplebudget.form.CreateBudgetForm;
import com.typicaldev.simplebudget.service.BudgetService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class BudgetLayout extends VerticalLayout implements Bus.Passenger {

    private BudgetService budgetService;

    private CreateBudgetForm createBudgetForm;

    private Bus bus;

    private Label budgetLabel = new Label();

    private Button createBudgetButton = new Button("Add new budget");


    @Autowired
    public BudgetLayout(final BudgetService budgetService,
                        final CreateBudgetForm createBudgetForm,
                        final Bus bus) {
        this.budgetService = budgetService;
        this.createBudgetForm = createBudgetForm;
        this.bus = bus;

        bus.getIn(this);

        //initLabel();

        initView();
    }

    private void initView() {
        initCreateBudgetButton();

        add(createBudgetButton);

        add(createBudgetForm);
    }

    private void initCreateBudgetButton() {
        createBudgetButton.addClickListener(event -> {
            createBudgetForm.setBudget(new BudgetCreateDto());
        });
    }

    private void initLabel() {
        final var budget = budgetService.getLatestBudget();

        if (budget != null) {
            budgetLabel.setText(String.valueOf(budget.getValue()));

            add(budgetLabel);
        }
    }

    @Subscribe
    public void onEvent(final CreateBudgetEvent event) {

    }
}