package com.springermis.server.api.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
    @PreAuthorize("hasAuthority('read:employee')")
    @PostAuthorize("returnObject.get().userId == authentication.name")
    Optional<Employee> findByUserId(String userId);

    @PreAuthorize("hasAuthority('create:employee')")
    @Override
    <S extends Employee> S save(S entity);

    @PreAuthorize("hasAuthority('create:employee')")
    @Override
    <S extends Employee> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('read:employee')")
    @PostAuthorize("returnObject.get().userId == authentication.name")
    @Override
    Optional<Employee> findById(UUID uuid);

    @PreAuthorize("hasAuthority('read:employee')")
    @Override
    boolean existsById(UUID uuid);

    @PreAuthorize("hasAuthority('read:employee')")
    @PostFilter("filterObject.userId == authentication.name")
    @Override
    Iterable<Employee> findAll();

    @PreAuthorize("hasAuthority('read:employee')")
    @PostFilter("filterObject.userId == authentication.name")
    @Override
    Iterable<Employee> findAllById(Iterable<UUID> uuids);

    @PreAuthorize("hasAuthority('read:employee')")
    @Override
    long count();

    @PreAuthorize("hasAuthority('delete:employee')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAuthority('delete:employee')")
    @Override
    void delete(Employee entity);

    @PreAuthorize("hasAuthority('delete:employee')")
    @Override
    void deleteAllById(Iterable<? extends UUID> uuids);

    @PreAuthorize("hasAuthority('delete:employee')")
    @Override
    void deleteAll(Iterable<? extends Employee> entities);

    @PreAuthorize("hasAuthority('delete:employee')")
    @Override
    void deleteAll();
}