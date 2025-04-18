package org.example.bootrestex.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.example.bootrestex.model.dto.AnimalRequestDTO;
import org.example.bootrestex.model.dto.GeminiRequestDTO;
import org.example.bootrestex.model.dto.GeminiResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@Log
public class GeminiServiceImpl implements GeminiService {
    @Value("${gemini.api-key}")
    private String apiKey;

    @Override
    public String makeStory(AnimalRequestDTO dto) throws IOException, InterruptedException {
        // 사전 설정
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=%s".formatted(apiKey);
        String prompt = "%s의 이름을 가진 %s 설명을 바탕으로 하는 생명체에 대한 이야기를 간결하게 평문으로 작성.".formatted(dto.name(), dto.description());
        // 이제 요청 형식 정하기
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json") // 타입은 json으로 보낼 것
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(new GeminiRequestDTO(List.of(new GeminiRequestDTO.Contents(List.of(new GeminiRequestDTO.Part(prompt)))))))) // 문자열의 형태로 자바 객체를 `직렬화` 한 뒤 POST 메서드를 통해 보낼것
                .build();

        // 이제 응답 받을 형식을 정할 차례
        // HTTP 응답 본문을 JSON 형태의 문자열 형태로 받아 response 객체 안에 저장
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // ResponseDTO record를 만들기 위해 응답형태를 미리 파악하자
        log.info(response.body());

        // 자바 객체로 역직렬화
        GeminiResponseDTO resp = objectMapper.readValue(response.body(), GeminiResponseDTO.class);

        return resp.candidates().get(0).content().parts().get(0).text(); // 리스트는 get(0)
    }
}
