package com.example.Coder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Card;

public interface CardRepo extends JpaRepository<Card,Long>{

    List<Card> findByBoardId(Long boardId);

    Card findByIdAndBoardId(Long cardId, Long boardId);

    void deleteByIdAndBoardId(Long cardId, Long boardId);
}
