package org.example.bootrestex.model.domain;

public record Animal(String uuid,
                     String name,
                     String description,
                     String story,
                     String createdAt) {
}
