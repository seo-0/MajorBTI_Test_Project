package com.example.mbti.domain.Mbti;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MbtiRepositoryTest {
    @Autowired
    MbtiRepository mbtiRepository;

    @After
    public void cleanup(){
        mbtiRepository.deleteAll();
    }
}