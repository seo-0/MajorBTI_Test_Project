package com.example.mbti.domain.Mbti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MbtiRepository extends JpaRepository<Mbti, Long> {
    @Query("SELECT m FROM Mbti m ORDER BY m.id DESC")
    List<Mbti> findAllDesc();
}