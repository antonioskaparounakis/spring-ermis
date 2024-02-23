package com.springermis.server.api.expenseReport;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RequestMapping("/expenseReports")
@RestController
public class ExpenseReportController {

    private final ExpenseReportService service;
    private final RepositoryEntityLinks entityLinks;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/submit")
    public EntityModel<ExpenseReport> submitById(@PathVariable UUID id) {
        ExpenseReport report = service.submitById(id);
        return EntityModel.of(
                report,
                linkTo(methodOn(ExpenseReportController.class).submitById(id)).withSelfRel(),
                entityLinks.linkToItemResource(ExpenseReport.class, id).withRel("expenseReport")
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/approve")
    public EntityModel<ExpenseReport> approveById(@PathVariable UUID id) {
        ExpenseReport report = service.approveById(id);
        return EntityModel.of(
                report,
                linkTo(methodOn(ExpenseReportController.class).approveById(id)).withSelfRel(),
                entityLinks.linkToItemResource(ExpenseReport.class, id).withRel("expenseReport")
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/reject")
    public EntityModel<ExpenseReport> rejectById(@PathVariable UUID id) {
        ExpenseReport report = service.rejectById(id);
        return EntityModel.of(
                report,
                linkTo(methodOn(ExpenseReportController.class).service.rejectById(id)).withSelfRel(),
                entityLinks.linkToItemResource(ExpenseReport.class, id).withRel("expenseReport")
        );
    }

}
