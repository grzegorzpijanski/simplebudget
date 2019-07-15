package com.typicaldev.simplebudget.form;

import com.typicaldev.simplebudget.dto.BudgetCreateDto;
import com.typicaldev.simplebudget.event.Bus;
import com.typicaldev.simplebudget.event.CreateBudgetEvent;
import com.typicaldev.simplebudget.service.BudgetService;
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
public class CreateBudgetForm extends FormLayout {

    private BudgetService budgetService;

    private Bus bus;

    private Binder<BudgetCreateDto> binder = new Binder<>(BudgetCreateDto.class);

    private TextField value = new TextField("Value");

    private Button saveBtn = new Button("Save");

    @Autowired
    public CreateBudgetForm(final BudgetService budgetService,
                            final Bus bus) {
        this.budgetService = budgetService;
        this.bus = bus;

        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        final VerticalLayout form = new VerticalLayout(value, saveBtn);
        form.setWidthFull();

        add(form);

        binder.forField(value)
                .withConverter(new StringToDoubleConverter("must be double"))
                .bind("value");

        binder.bindInstanceFields(this);

        saveBtn.addClickListener(event -> save());
    }

    public void setBudget(final BudgetCreateDto dto) {
        binder.setBean(dto);

        if (dto == null) {
            setVisible(false);
        } else {
            setVisible(true);
            value.focus();
        }
    }

    private void save() {
        final BudgetCreateDto dto = binder.getBean();
        budgetService.addBudget(dto);
        bus.yell(new CreateBudgetEvent());
        setBudget(null);
    }
}