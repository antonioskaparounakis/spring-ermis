package com.springermis.server.api.expenseReport;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ExpenseReportModelProcessor implements RepresentationModelProcessor<EntityModel<ExpenseReport>> {
    @Override
    public EntityModel<ExpenseReport> process(EntityModel<ExpenseReport> model) {
        ExpenseReport expenseReport = model.getContent();

        if (expenseReport == null) {
            return model;
        }
        switch (expenseReport.getStatus()) {
            case DRAFT ->
                    model.add(linkTo(methodOn(ExpenseReportController.class).submitById(expenseReport.getId())).withRel("submit"));
            case SUBMITTED -> {
                model.add(linkTo(methodOn(ExpenseReportController.class).approveById(expenseReport.getId())).withRel("approve"));
                model.add(linkTo(methodOn(ExpenseReportController.class).rejectById(expenseReport.getId())).withRel("reject"));
            }
        }

        return model;
    }
}