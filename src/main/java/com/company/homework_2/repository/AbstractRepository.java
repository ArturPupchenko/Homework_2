package com.company.homework_2.repository;

import com.company.homework_2.data.AbstractData;

import java.util.List;

public interface AbstractRepository<T extends AbstractData<T>> {

    void save(T t);
    T findById(Long id);
    List<T> findAll();
    void update(T t);
    void remove(Long id);
}
