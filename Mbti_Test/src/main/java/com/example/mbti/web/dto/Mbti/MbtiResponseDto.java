package com.example.mbti.web.dto.Mbti;

import com.example.mbti.domain.Mbti.Mbti;
import lombok.Builder;

public class MbtiResponseDto {
    private Long id;
    private int EI;
    private int SN;
    private  int TF;
    private int JP;
    private String result;

    public MbtiResponseDto() {
    }

    @Builder
    public MbtiResponseDto(Mbti entity) {
        this.id = entity.getId();
        this.EI = entity.getEI();
        this.SN = entity.getSN();
        this.TF = entity.getTF();
        this.JP = entity.getJP();
        this.result = entity.getResult();
    }
}
