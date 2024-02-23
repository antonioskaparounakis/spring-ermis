package com.springermis.server.api.expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository extends CrudRepository<Expense, UUID> {
    @PreAuthorize("hasAuthority('create:expense')")
    @Override
    <S extends Expense> S save(S entity);

    @PreAuthorize("hasAuthority('create:expense')")
    @Override
    <S extends Expense> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('read:expense')")
    @Override
    Optional<Expense> findById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense')")
    @Override
    boolean existsById(UUID uuid);

    @PreAuthorize("hasAuthority('read:expense')")
    @Override
    Iterable<Expense> findAll();

    @PreAuthorize("hasAuthority('read:expense')")
    @Override
    Iterable<Expense> findAllById(Iterable<UUID> uuids);

    @PreAuthorize("hasAuthority('read:expense')")
    @Override
    long count();

    @PreAuthorize("hasAuthority('delete:expense')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAuthority('delete:expense')")
    @Override
    void delete(Expense entity);

    @PreAuthorize("hasAuthority('delete:expense')")
    @Override
    void deleteAllById(Iterable<? extends UUID> uuids);

    @PreAuthorize("hasAuthority('delete:expense')")
    @Override
    void deleteAll(Iterable<? extends Expense> entities);

    @PreAuthorize("hasAuthority('delete:expense')")
    @Override
    void deleteAll();
}