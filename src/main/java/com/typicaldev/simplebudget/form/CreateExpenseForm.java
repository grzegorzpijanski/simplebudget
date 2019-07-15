package com.typicaldev.simplebudget.form;

import com.typicaldev.simplebudget.dto.ExpenseCreateDto;
import com.typicaldev.simplebudget.service.ExpenseService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class CreateExpenseForm extends FormLayout {

    private ExpenseService expenseService;

    private Binder<ExpenseCreateDto> binder = new Binder<>(ExpenseCreateDto.class);

    private TextField name = new TextField("Name");
    private TextField plannedValue = new TextField("Planned value");
    private TextField realValue = new TextField("Real value");

    private Button saveBtn = new Button("Save");

    @Autowired
    public CreateExpenseForm(final ExpenseService expenseService) {
        this.expenseService = expenseService;

        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        final VerticalLayout form = new VerticalLayout(name, plannedValue, realValue, saveBtn);
        form.setWidthFull();

        add(form);

        binder.forField(plannedValue)
                .withConverter(new StringToDoubleConverter("must be double"))
                .bind("plannedValue");

        binder.forField(realValue)
                .withConverter(new StringToDoubleConverter("must be double"))
                .bind("realValue");

        binder.bindInstanceFields(this);

        saveBtn.addClickListener(event -> save());
    }

    public void setExpense(final ExpenseCreateDto dto) {
        binder.setBean(dto);

        if (dto == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }

    private void save() {
        final ExpenseCreateDto dto = binder.getBean();
        expenseService.addExpense(dto);

        setExpense(null);
    }
}