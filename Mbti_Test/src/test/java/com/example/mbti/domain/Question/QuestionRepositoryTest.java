package com.example.mbti.domain.Question;

import com.example.mbti.domain.Mbti.MbtiRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @After
    public void cleanup(){
        questionRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        int EI=1;
        int SN=0;
        int TF=0;
        int JP=0;
        String question="질문1입니다.";

        questionRepository.save(Question.builder()
                .EI(EI)
                .SN(SN)
                .TF(TF)
                .JP(JP)
                .question(question)
                .build());

        //when
        List<Question> questionList = questionRepository.findAll();


        //then
        Question question1 = questionList.get(0);
        assertThat(question1.getEI()).isEqualTo(1);
    }
}