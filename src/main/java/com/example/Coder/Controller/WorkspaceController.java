package com.example.Coder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;
import com.example.Coder.Service.WorkspaceService;

@RestController
@RequestMapping("/api/v1/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<Void> createWorkspace(@RequestBody WorkspaceRequest workspaceRequest) {
        workspaceService.addWorkspace(workspaceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Workspace>> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceService.getAllWorkspaces();
        return ResponseEntity.ok(workspaces);
    }

    @GetMapping("/{workspaceId}")
    public ResponseEntity<Workspace> getWorkspace(@PathVariable Long workspaceId) {
        System.out.println("hello world");
        Workspace workspace = workspaceService.getWorkspace(workspaceId);
        return ResponseEntity.ok(workspace);
    }

    @PutMapping("/{workspaceId}")
    public ResponseEntity<Void> updateWorkspace(@RequestBody WorkspaceRequest workspaceRequest,
            @PathVariable Long workspaceId) {
        workspaceService.updateWorkspace(workspaceRequest, workspaceId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspaceId}")
    public ResponseEntity<Void> removeWorkspace(@PathVariable Long workspaceId) {
        workspaceService.removeWorkspace(workspaceId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/togglePrivacy")
    public ResponseEntity<Void> togglePrivacy(@PathVariable Long workspaceId) {
        workspaceService.toggleIsprivacy(workspaceId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{workspaceId}/boards")
    public ResponseEntity<List<Board>> getAllBoards(@PathVariable Long workspaceId) {
        System.out.println("hello world");
        List<Board> boards = workspaceService.getAllBoards(workspaceId);
        return ResponseEntity.ok(boards);
    }

    @PostMapping("/{workspaceId}/boards")
    public ResponseEntity<Void> createBoard(@PathVariable Long workspaceId, @RequestBody BoardRequest boardRequest) {
        workspaceService.addBoard(workspaceId, boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{workspaceId}/boards/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        Board board = workspaceService.getBoard(workspaceId, boardId);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{workspaceId}/boards/{boardId}")
    public ResponseEntity<Void> updateBoard(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @RequestBody BoardRequest boardRequest) {
        workspaceService.updateBoard(workspaceId, boardId, boardRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspaceId}/boards/{boardId}")
    public ResponseEntity<Void> removeBoard(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        workspaceService.removeBoard(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/boards/{boardId}/toggleArchive")
    public ResponseEntity<Void> toggleBoardIsArchive(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        workspaceService.toggleBoardIsArchive(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/boards/{boardId}/toggleFavorite")
    public ResponseEntity<Void> toggleBoardIsFavorite(@PathVariable Long workspaceId, @PathVariable Long boardId) {
        workspaceService.toggleBoardIsFavorite(workspaceId, boardId);
        return ResponseEntity.ok().build();
    }
}
