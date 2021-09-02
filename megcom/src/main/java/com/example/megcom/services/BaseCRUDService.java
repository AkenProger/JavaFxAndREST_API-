package com.example.megcom.services;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseCRUDService<S, T> {

    S save(S s);
    S update(S s);
    List<S> findAll();
    S findById(T id);
    void deleteById(Long id);

}
