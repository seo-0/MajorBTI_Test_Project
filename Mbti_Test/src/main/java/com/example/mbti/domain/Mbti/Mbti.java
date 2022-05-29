package com.example.mbti.domain.Mbti;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Mbti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=10, nullable=false)
    private int EI;

    @Column(length=10, nullable=false)
    private int SN;

    @Column(length=10, nullable=false)
    private  int TF;

    @Column(length=10, nullable=false)
    private int JP;

    @Column(length=200, nullable=false)
    private String result;

    @Builder
    public Mbti(int EI, int SN, int TF, int JP, String result) {
        this.EI = EI;
        this.SN = SN;
        this.TF = TF;
        this.JP = JP;
        this.result = result;
    }
}
