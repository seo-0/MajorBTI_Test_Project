package com.example.mbti.web.dto.Question;

import com.example.mbti.domain.Question.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {
    private int EI;
    private int SN;
    private int TF;
    private int JP;
    private String question;

    @Builder
    public QuestionSaveRequestDto(int EI, int SN, int TF, int JP, String question) {
        this.EI = EI;
        this.SN = SN;
        this.TF = TF;
        this.JP = JP;
        this.question = question;
    }

    public Question toEntity(){
        return Question.builder()
                .EI(EI)
                .SN(SN)
                .TF(TF)
                .JP(JP)
                .question(question)
                .build();
    }
}
