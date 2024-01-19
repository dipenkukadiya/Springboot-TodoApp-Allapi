package com.example.Coder.Controller;

import com.example.Coder.DTO.CardDTO;
import com.example.Coder.Request.CardRequest;
import com.example.Coder.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workspaces")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/{workspaceId}/boards/{boardId}/cards")
    public ResponseEntity<List<CardDTO>> getAllCardsByBoardId(@PathVariable Long workspaceId,
            @PathVariable Long boardId) {
        List<CardDTO> cards = cardService.getAllCardByWIdndBId(workspaceId, boardId);
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{workspaceId}/boards/{boardId}/cards/{cardId}")
    public ResponseEntity<CardDTO> getCardByCardId(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long cardId) {
        CardDTO card = cardService.getBoardByBoardid(workspaceId, boardId, cardId);
        if (card != null) {
            return ResponseEntity.ok(card);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{workspaceId}/boards/{boardId}/cards")
    public ResponseEntity<Void> addCard(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @RequestBody CardRequest cardRequest) {
        cardService.addCard(workspaceId, boardId, cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{workspaceId}/boards/{boardId}/cards/{cardId}")
    public ResponseEntity<Void> updateCard(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long cardId, @RequestBody CardRequest cardRequest) {
        cardService.updateCard(workspaceId, boardId, cardId, cardRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspaceId}/boards/{boardId}/cards/{cardId}")
    public ResponseEntity<Void> removeCard(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long cardId) {
        cardService.removeCard(workspaceId, boardId, cardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/boards/{boardId}/cards/{cardId}/toggleArchive")
    public ResponseEntity<Void> toggleCardIsArchive(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long cardId) {
        cardService.toggleCardIsArchive(workspaceId, boardId, cardId);
        return ResponseEntity.ok().build();
    }
}
