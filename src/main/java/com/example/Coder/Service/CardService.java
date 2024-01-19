package com.example.Coder.Service;

import java.util.List;


import com.example.Coder.DTO.CardDTO;

import com.example.Coder.Request.CardRequest;

public interface CardService {
    List<CardDTO> getAllCardByWIdndBId(Long workspace_id,Long board_id);

    CardDTO getBoardByBoardid(Long workspace_id, Long board_id,Long card_id);

    void addCard(Long workspace_id,Long board_id, CardRequest cardRequest);

    void updateCard(Long workspace_id, Long board_id,Long card_id, CardRequest cardRequest);

    void removeCard(Long workspace_id, Long board_id ,Long card_id);

    void toggleCardIsArchive(Long workspace_id, Long board_id ,Long card_id);

    
    
}
