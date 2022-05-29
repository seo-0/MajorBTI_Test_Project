package com.example.mbti.service;

import com.example.mbti.domain.Question.Question;
import com.example.mbti.domain.Question.QuestionRepository;
import com.example.mbti.web.dto.Question.QuestionListResponseDto;
import com.example.mbti.web.dto.Question.QuestionResponseDto;
import com.example.mbti.web.dto.Question.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {
    public final QuestionRepository questionRepository;

    @Transactional
    public Long save(QuestionSaveRequestDto requestDto){
        return questionRepository.save(requestDto.toEntity()).getId();
    }

    public QuestionResponseDto findById(Long id){
        Question entity = questionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        return new QuestionResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<QuestionListResponseDto> findAllDesc(){
        return questionRepository.findAllDesc().stream()
                .map(QuestionListResponseDto::new)
                .collect(Collectors.toList());
    }


}
