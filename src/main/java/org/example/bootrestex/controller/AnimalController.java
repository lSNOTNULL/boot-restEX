package org.example.bootrestex.controller;

import org.example.bootrestex.model.domain.Animal;
import org.example.bootrestex.model.dto.AnimalRequestDTO;
import org.example.bootrestex.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Spring -> 의존성 주입 스캔용
@RequestMapping("/api/animal")
public class AnimalController {
    private final AnimalService animalService;
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }
    @GetMapping
    public List<Animal> all(){
        return animalService.findAll();
    }
    @PostMapping
    public Animal create(@RequestBody AnimalRequestDTO dto) {
        return null;
    }
}
