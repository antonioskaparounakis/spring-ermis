package com.springermis.server.api.expenseReport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseReportRepository extends CrudRepository<ExpenseReport, UUID> {

    @RestResource(path = "/findByManagerId")
    @Query("select e from ExpenseReport e where e.employee.manager.id = ?1 order by e.createdDate DESC")
    List<ExpenseReport> findByEmployee_Manager_UserIdOrderByCreatedDateDesc(UUID managerId);

    @PreAuthorize("hasAuthority('create:expense_report')")
    @Override
    <S extends ExpenseReport> S save(S entity);

    @PreAuthorize("hasAuthority('create:expense_report')")
    @Override
    <S extends ExpenseReport> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('read:expense_report')")
    @PostAuthorize("returnObject.get().employee.userId == authentication.name")
    @Override
    Optional<ExpenseReport> findById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense_report')")
    @Override
    boolean existsById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense_report')")
    @PostFilter("filterObject.employee.userId == authentication.name")
    @Override
    Iterable<ExpenseReport> findAll();

    @PreAuthorize("hasAuthority('read:expense_report')")
    @PostFilter("filterObject.employee.userId == authentication.name")
    @Override
    Iterable<ExpenseReport> findAllById(Iterable<UUID> uuids);

    @PreAuthorize("hasAuthority('read:expense_report')")
    @Override
    long count();

    @PreAuthorize("hasAuthority('delete:expense_report')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAuthority('delete:expense_report')")
    @Override
    void delete(ExpenseReport entity);

    @PreAuthorize("hasAuthority('delete:expense_report')")
    @Override
    void deleteAllById(Iterable<? extends UUID> uuids);

    @PreAuthorize("hasAuthority('delete:expense_report')")
    @Override
    void deleteAll(Iterable<? extends ExpenseReport> entities);

    @PreAuthorize("hasAuthority('delete:expense_report')")
    @Override
    void deleteAll();
}