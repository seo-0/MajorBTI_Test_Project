package com.example.mbti.web.dto.Mbti;

import com.example.mbti.domain.Mbti.Mbti;
import lombok.Builder;

public class MbtiSaveRequestDto {
    private Long id;
    private int EI;
    private int SN;
    private  int TF;
    private int JP;
    private String result;

    @Builder
    public MbtiSaveRequestDto(int EI, int SN, int TF, int JP, String result) {
        this.EI = EI;
        this.SN = SN;
        this.TF = TF;
        this.JP = JP;
        this.result = result;
    }

    public Mbti toEntity(){
        return Mbti.builder()
                .EI(EI)
                .SN(SN)
                .TF(TF)
                .JP(JP)
                .result(result)
                .build();
    }
}
