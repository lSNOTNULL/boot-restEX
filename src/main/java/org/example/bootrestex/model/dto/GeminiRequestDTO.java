package org.example.bootrestex.model.dto;

import java.util.List;

/*
-d '{
  "contents": [{
    "parts":[{"text": "Explain how AI works"}]
    }]
   }'
*/
public record GeminiRequestDTO(
        List<Contents> contents
) {
    public record Contents(List<Part> parts){}
    public record Part(String text){}
}
