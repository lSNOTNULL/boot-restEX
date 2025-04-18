package org.example.bootrestex.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.bootrestex.model.dto.AnimalRequestDTO;

import java.io.IOException;

public interface GeminiService {
    String makeStory(AnimalRequestDTO dto) throws IOException, InterruptedException;
}
