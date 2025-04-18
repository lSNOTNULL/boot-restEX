package org.example.bootrestex.service;

import org.apache.coyote.BadRequestException;
import org.example.bootrestex.model.domain.Animal;
import org.example.bootrestex.model.mapper.AnimalMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    AnimalMapper animalMapper;
    public AnimalServiceImpl(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }

    @Override
    public List<Animal> findAll() {
        return animalMapper.findAll();
    }

    @Override
    public void create(Animal animal) throws BadRequestException {
        if(animal.name().isEmpty()) {
          throw new BadRequestException("이름을 비울 수 없음");
        }
        if (animal.description().isEmpty()) {
            throw new BadRequestException("설명을 비울 수 없음");
        }
        animalMapper.insert(animal);
    }

}
