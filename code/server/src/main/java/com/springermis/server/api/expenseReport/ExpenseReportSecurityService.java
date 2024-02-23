package com.springermis.server.api.expenseReport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExpenseReportSecurityService {

    private final ExpenseReportRepository repository;

    public boolean userOwnsExpenseReport(String userId, UUID expenseReportId) {
        return repository.findById(expenseReportId)
                .map(expenseReport -> expenseReport.getEmployee().getUserId().equals(userId))
                .orElse(false);
    }

    public boolean userManagesExpenseReportOwner(String userId, UUID expenseReportId) {
        return repository.findById(expenseReportId)
                .map(expenseReport -> expenseReport.getEmployee().getManager().getUserId().equals(userId))
                .orElse(false);
    }

}
