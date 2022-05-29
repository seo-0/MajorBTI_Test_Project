package com.example.mbti.web.dto.Question;

import com.example.mbti.domain.Question.Question;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuestionResponseDto {
    private Long id;
    private int EI;
    private int SN;
    private int TF;
    private int JP;
    private String question;

    public QuestionResponseDto() {
    }

    @Builder
    public QuestionResponseDto(Question entity) {
        this.id = entity.getId();
        this.EI = entity.getEI();
        this.SN = entity.getSN();
        this.TF = entity.getTF();
        this.JP = entity.getJP();
        this.question = entity.getQuestion();
    }
}
