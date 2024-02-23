package com.springermis.server.api.expenseReport;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExpenseReportService {

    private final ExpenseReportRepository repository;

    @PreAuthorize("@expenseReportSecurityService.userOwnsExpenseReport(authentication.name, #id)")
    public ExpenseReport submitById(UUID id) {
        ExpenseReport expenseReport = this.findExpenseReportById(id);
        if (expenseReport.getStatus() != ExpenseReportStatus.DRAFT) {
            throw new IllegalStateException();
        }
        expenseReport.setStatus(ExpenseReportStatus.SUBMITTED);
        return expenseReport;
    }


    @PreAuthorize("hasAuthority('approve:expense_report') AND @expenseReportSecurityService.userManagesExpenseReportOwner(authentication.name, #id)")
    public ExpenseReport approveById(UUID id) {
        ExpenseReport expenseReport = this.findExpenseReportById(id);
        if (expenseReport.getStatus() != ExpenseReportStatus.SUBMITTED) {
            throw new IllegalStateException();
        }
        expenseReport.setStatus(ExpenseReportStatus.APPROVED);
        return expenseReport;
    }

    @PreAuthorize("hasAuthority('reject:expense_report') AND @expenseReportSecurityService.userManagesExpenseReportOwner(authentication.name, #id)")
    public ExpenseReport rejectById(UUID id) {
        ExpenseReport expenseReport = this.findExpenseReportById(id);
        if (expenseReport.getStatus() != ExpenseReportStatus.SUBMITTED) {
            throw new IllegalStateException();
        }
        expenseReport.setStatus(ExpenseReportStatus.REJECTED);
        return expenseReport;
    }


    private ExpenseReport findExpenseReportById(UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
