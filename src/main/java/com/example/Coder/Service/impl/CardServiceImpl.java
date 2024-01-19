package com.example.Coder.Service.impl;

import com.example.Coder.DTO.CardDTO;
import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Card;
import com.example.Coder.Repository.CardRepo;
import com.example.Coder.Repository.BoardRepo;
import com.example.Coder.Service.CardService;
import com.example.Coder.Request.CardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private BoardRepo boardRepo;

    @Override
    public List<CardDTO> getAllCardByWIdndBId(Long workspaceId, Long boardId) {
        // Assuming CardRepo has a method to find cards by boardId
        List<Card> cards = cardRepo.findByBoardId(boardId);
        return convertCardsToDTOs(cards);
    }

    @Override
    public CardDTO getBoardByBoardid(Long workspaceId, Long boardId, Long cardId) {
        Card card = cardRepo.findByIdAndBoardId(cardId, boardId);
        return convertCardToDTO(card);
    }

    @Override
    public void addCard(Long workspaceId, Long boardId, CardRequest cardRequest) {
        // Assuming BoardRepo has a method to find a board by id
        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Card card = new Card();
            card.setName(cardRequest.getName());
            card.setCardIndex(cardRequest.getCardIndex());
            card.setCardKey(cardRequest.getCardKey());
            card.setArchive(cardRequest.isArchive());
            card.setBoard(board);
            cardRepo.save(card);
        }
    }

    @Override
    public void updateCard(Long workspaceId, Long boardId, Long cardId, CardRequest cardRequest) {
        // Assuming BoardRepo has a method to find a board by id
        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Card card = cardRepo.findByIdAndBoardId(cardId, boardId);
            if (card != null) {
                card.setName(cardRequest.getName());
                card.setCardIndex(cardRequest.getCardIndex());
                card.setCardKey(cardRequest.getCardKey());
                card.setArchive(cardRequest.isArchive());
                card.setBoard(board);
                cardRepo.save(card);
            }
        }
    }

    @Override
    public void removeCard(Long workspaceId, Long boardId, Long cardId) {
        // Assuming BoardRepo has a method to find a board by id
        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            cardRepo.deleteById(cardId);
        }
    }

    @Override
    public void toggleCardIsArchive(Long workspaceId, Long boardId, Long cardId) {
        // Assuming BoardRepo has a method to find a board by id
        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Card card = cardRepo.findByIdAndBoardId(cardId, boardId);
            if (card != null) {
                card.setArchive(!card.getArchive());
                cardRepo.save(card);
            }
        }
    }

    private List<CardDTO> convertCardsToDTOs(List<Card> cards) {
        return cards.stream()
                .map(this::convertCardToDTO)
                .collect(Collectors.toList());
    }

    private CardDTO convertCardToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setName(card.getName());
        cardDTO.setCardKey(card.getCardKey());
        cardDTO.setCardIndex(card.getCardIndex());
        cardDTO.setArchive(card.getArchive());

        return cardDTO;
    }
}
