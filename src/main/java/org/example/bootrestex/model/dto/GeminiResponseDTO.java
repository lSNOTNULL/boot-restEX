package org.example.bootrestex.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*
"candidates": [ // 리스트임
    {
      "content": { // 리스트아님
        "parts": [ // 리스트임
          {
            "text": "프라이데이는 태어날 때부터 두근거리는 심장을 가진 존재였다. 금요일의 설렘을 먹고 자라, 낡은 달력의 마지막 장처럼 아쉬움과 기대를 동시에 품었다. 학교 종소리에 맞춰 날개를 펼치고, 퇴근길 석양 아래 춤을 추며 사람들의 지친 어깨를 토닥였다. 그의 존재는 짧지만 강렬했다. 주말을 기다리는 모든 이들의 마음속에 작은 불꽃을 지피는 것, 그것이 그의 운명이었다.\n"
          }
        ],
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public record GeminiResponseDTO(List<Candidate> candidates){

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Candidate(Content content){}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Content(List<Part> parts){}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Part(String text){}
}
