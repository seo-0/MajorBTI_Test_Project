package com.example.mbti.web.dto.Question;

import com.example.mbti.domain.Question.Question;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuestionListResponseDto {
    private Long id;
    private int EI;
    private int SN;
    private int TF;
    private int JP;
    private String question;

    @Builder
    public QuestionListResponseDto(Question entity) {
        this.id = entity.getId();
        this.EI = entity.getEI();
        this.SN = entity.getSN();
        this.TF = entity.getTF();
        this.JP = entity.getJP();
        this.question = entity.getQuestion();
    }
}
