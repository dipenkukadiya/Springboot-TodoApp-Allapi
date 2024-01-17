package com.example.Coder.Controller;

import java.util.List;

import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Workspace;
import com.example.Coder.Request.BoardRequest;
import com.example.Coder.Request.WorkspaceRequest;
import com.example.Coder.Service.WorkspaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<Void> addWorkspace(@RequestBody WorkspaceRequest workspaceRequest) {
        workspaceService.addWorkspace(workspaceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Workspace> getWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{workspace_id}")
    public ResponseEntity<Workspace> getWorkspace(@PathVariable Long workspace_id) {
        Workspace workspace = workspaceService.getWorkspace(workspace_id);
        return ResponseEntity.ok(workspace);
    }

    @PutMapping("/{workspace_id}")
    public ResponseEntity<Void> updateWorkspace(@RequestBody WorkspaceRequest workspaceRequest, @PathVariable Long workspace_id) {
        workspaceService.updateWorkspace(workspaceRequest, workspace_id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspace_id}")
    public ResponseEntity<Void> removeWorkspace(@PathVariable Long workspace_id) {
        workspaceService.removeWorkspace(workspace_id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/togglePrivacy/{workspace_id}")
    public ResponseEntity<Void> togglePrivacy(@PathVariable Long workspace_id) {
        workspaceService.toggleIsprivacy(workspace_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{workspace_id}/boards")
    public ResponseEntity<List<Board>> getAllBoards(@PathVariable Long workspace_id) {
        List<Board> boards = workspaceService.getAllBoards(workspace_id);
        return ResponseEntity.ok(boards);
    }

    @PostMapping("/{workspace_id}/boards")
    public ResponseEntity<Void> addBoard(@PathVariable Long workspace_id, @RequestBody BoardRequest boardRequest) {
        workspaceService.addBoard(workspace_id, boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{workspace_id}/boards/{board_id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long workspace_id, @PathVariable Long board_id) {
        Board board = workspaceService.getBoard(workspace_id, board_id);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{workspace_id}/boards/{board_id}")
    public ResponseEntity<Void> updateBoard(@PathVariable Long workspace_id, @PathVariable Long board_id, @RequestBody BoardRequest boardRequest) {
        workspaceService.updateBoard(workspace_id, board_id, boardRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspace_id}/boards/{board_id}")
    public ResponseEntity<Void> removeBoard(@PathVariable Long workspace_id, @PathVariable Long board_id) {
        workspaceService.removeBoard(workspace_id, board_id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspace_id}/boards/{board_id}/toggleArchive")
    public ResponseEntity<Void> toggleBoardIsArchive(@PathVariable Long workspace_id, @PathVariable Long board_id) {
        workspaceService.toggleBoardIsArchive(workspace_id, board_id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspace_id}/boards/{board_id}/toggleFavorite")
    public ResponseEntity<Void> toggleBoardIsFavorite(@PathVariable Long workspace_id, @PathVariable Long board_id) {
        workspaceService.toggleBoardIsFavorite(workspace_id, board_id);
        return ResponseEntity.ok().build();
    }
}
