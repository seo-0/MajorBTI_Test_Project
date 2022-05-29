package com.example.mbti.service;

import com.example.mbti.domain.Mbti.Mbti;
import com.example.mbti.domain.Mbti.MbtiRepository;
import com.example.mbti.web.dto.Mbti.MbtiListResponseDto;
import com.example.mbti.web.dto.Mbti.MbtiResponseDto;
import com.example.mbti.web.dto.Mbti.MbtiSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MbtiService {
    public final MbtiRepository mbtiRepository;

    @Transactional
    public Long save(MbtiSaveRequestDto requestDto){
        return mbtiRepository.save(requestDto.toEntity()).getId();
    }

    public MbtiResponseDto findById(Long id){
        Mbti entity = mbtiRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        return new MbtiResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MbtiListResponseDto> findAllDesc(){
        return mbtiRepository.findAllDesc().stream()
                .map(MbtiListResponseDto::new)
                .collect(Collectors.toList());
    }
}

