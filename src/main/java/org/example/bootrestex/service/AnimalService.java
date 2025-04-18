package org.example.bootrestex.service;

import org.apache.coyote.BadRequestException;
import org.example.bootrestex.model.domain.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAll();


    void create(Animal animal) throws BadRequestException;
}
