package org.example.bootrestex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.BadRequestException;
import org.example.bootrestex.model.domain.Animal;
import org.example.bootrestex.model.dto.AnimalRequestDTO;
import org.example.bootrestex.service.AnimalService;
import org.example.bootrestex.service.GeminiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController // Spring -> 이거 아니라고... 주소 아니고
@RequestMapping("/api/animals") // 이겁니다...
public class AnimalController {
    private final AnimalService animalService;
    private final GeminiService geminiService;

    public AnimalController(AnimalService animalService, GeminiService geminiService) {
        this.animalService = animalService;
        this.geminiService = geminiService;
    }

    //    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

    // GET http://localhost:8080/api/animals
    @GetMapping
    public List<Animal> all() {
        return animalService.findAll();
    }

    // POST http://localhost:8080/api/animals
    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody AnimalRequestDTO dto) throws IOException, InterruptedException {
        String story = geminiService.makeStory(dto); // AI가 붙을 거임
        animalService.create(dto.toAnimal(story));
        return new ResponseEntity<>(HttpStatus.CREATED); // 201로 리턴됨.
        // JPA - 객체를 결과로 줌 (저장된 데이터 자체를 돌려줌) + 201
        // MyBatis - 201 상태만 줌.
    }
}
