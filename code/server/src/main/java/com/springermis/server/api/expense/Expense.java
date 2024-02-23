package com.springermis.server.api.expense;

import com.springermis.server.api.expenseReport.ExpenseReport;
import com.springermis.server.api.expenseType.ExpenseType;
import com.springermis.server.audit.AuditMetadata;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "expense")
public class Expense extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "expense_report_id", nullable = false)
    private ExpenseReport expenseReport;

    @ManyToOne(optional = false)
    @JoinColumn(name = "expense_type_id", nullable = false)
    private ExpenseType expenseType;

    @Column(name = "merchant", nullable = false)
    private String merchant;

    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "incurred_on", nullable = false)
    private Date incurredOn;

    @Column(name = "has_receipt", nullable = false)
    private Boolean hasReceipt = false;

    @Column(name = "description")
    private String  description;

}