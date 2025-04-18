package org.example.bootrestex.model.dto;

import org.example.bootrestex.model.domain.Animal;

import java.util.UUID;

public record AnimalRequestDTO(String name,
                               String description) {
    public Animal toAnimal(String story) {
        return new Animal("", name, description, story, "");
    }
}
