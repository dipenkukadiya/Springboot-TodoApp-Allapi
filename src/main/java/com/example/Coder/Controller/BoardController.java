package com.example.Coder.Controller;

import com.example.Coder.DTO.BoardDTO;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workspaces/{workspaceId}/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoardsByWorkspaceId(@PathVariable Long workspaceId) {
        List<BoardDTO> boards = boardService.getAllBoardByWorkspaceId(workspaceId);
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> getBoardByWorkspaceId(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        BoardDTO board = boardService.getBoardByWorkspaceid(workspaceId, boardId);
        if (board != null) {
            return ResponseEntity.ok(board);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addBoard(@PathVariable Long workspaceId, @RequestBody BoardRequest boardRequest) {
        boardService.addBoard(workspaceId, boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Void> updateBoard(@PathVariable Long workspaceId, @PathVariable Long boardId, @RequestBody BoardRequest boardRequest) {
        boardService.updateBoard(workspaceId, boardId, boardRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> removeBoard(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        boardService.removeBoard(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}/toggleArchive")
    public ResponseEntity<Void> toggleBoardIsArchive(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        boardService.toggleBoardIsArchive(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}/toggleFavorite")
    public ResponseEntity<Void> toggleBoardIsFavorite(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        boardService.toggleBoardIsFavorite(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }
}
