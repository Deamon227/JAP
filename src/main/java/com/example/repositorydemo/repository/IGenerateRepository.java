package com.example.repositorydemo.repository;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll(); //return list

    T findById(Long id); //return an object

    void save(T t); //create: save object, return data not important atm

    void remove(Long id); //return void
}
