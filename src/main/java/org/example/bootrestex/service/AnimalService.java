package org.example.bootrestex.service;

import org.example.bootrestex.model.domain.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAll();

    Animal save(Animal animal);
}
