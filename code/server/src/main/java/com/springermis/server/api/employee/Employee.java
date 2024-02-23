package com.springermis.server.api.employee;

import com.springermis.server.api.expenseReport.ExpenseReport;
import com.springermis.server.audit.AuditMetadata;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "employee", indexes = {
        @Index(name = "idx_employee_user_id_unq", columnList = "user_id", unique = true)
})
public class Employee extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    @OrderBy("createdDate DESC")
    private List<ExpenseReport> expenseReports = new ArrayList<>();

}