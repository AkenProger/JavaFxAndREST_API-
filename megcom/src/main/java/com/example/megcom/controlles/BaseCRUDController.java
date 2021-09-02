package com.example.megcom.controlles;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseCRUDController<S, T> {
    @PostMapping("/save")
    S save(@RequestBody S S);

    @PutMapping("/update")
    S update(@RequestBody S s);

    @GetMapping("/all")
    List<S> findAll();

    @GetMapping("/{id}")
    S findById(@PathVariable T id);

    @GetMapping("/delete/{id}")
    void deleteById(@PathVariable Long id);


}
