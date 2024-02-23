package com.springermis.server.api.expenseType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;
import java.util.UUID;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, UUID> {

    @PreAuthorize("hasAuthority('create:expense_type')")
    @Override
    <S extends ExpenseType> S save(S entity);

    @PreAuthorize("hasAuthority('create:expense_type')")
    @Override
    <S extends ExpenseType> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('read:expense_type')")
    @Override
    Optional<ExpenseType> findById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense_type')")
    @Override
    boolean existsById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense_type')")
    @Override
    Iterable<ExpenseType> findAll();

    @PreAuthorize("hasAuthority('read:expense_type')")
    @Override
    Iterable<ExpenseType> findAllById(Iterable<UUID> uuids);

    @PreAuthorize("hasAuthority('read:expense_type')")
    @Override
    long count();

    @PreAuthorize("hasAuthority('delete:expense_type')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAuthority('delete:expense_type')")
    @Override
    void delete(ExpenseType entity);

    @PreAuthorize("hasAuthority('delete:expense_type')")
    @Override
    void deleteAllById(Iterable<? extends UUID> uuids);

    @PreAuthorize("hasAuthority('delete:expense_type')")
    @Override
    void deleteAll(Iterable<? extends ExpenseType> entities);

    @PreAuthorize("hasAuthority('delete:expense_type')")
    @Override
    void deleteAll();
}