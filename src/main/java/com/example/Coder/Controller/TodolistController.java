package com.example.Coder.Controller;

import com.example.Coder.DTO.TodolistDTO;
import com.example.Coder.Request.TodolistRequest;
import com.example.Coder.Service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workspaces")
public class TodolistController {

    @Autowired
    private TodolistService todolistService;

    @GetMapping("/{workspaceId}/boards/{boardId}/todolists")
    public ResponseEntity<List<TodolistDTO>> getAllTodolistsByBoardId(@PathVariable Long workspaceId,
            @PathVariable Long boardId) {
        List<TodolistDTO> todolists = todolistService.getAllTodolistByWIdndBId(workspaceId, boardId);
        return ResponseEntity.ok(todolists);
    }

    @GetMapping("/{workspaceId}/boards/{boardId}/todolists/{todolistId}")
    public ResponseEntity<TodolistDTO> getTodolistById(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long todolistId) {
        TodolistDTO todolist = todolistService.getTodolistByid(workspaceId, boardId, todolistId);
        if (todolist != null) {
            return ResponseEntity.ok(todolist);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{workspaceId}/boards/{boardId}/todolists")
    public ResponseEntity<Void> addTodolist(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @RequestBody TodolistRequest todolistRequest) {
        todolistService.addTodolist(workspaceId, boardId, todolistRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{workspaceId}/boards/{boardId}/todolists/{todolistId}")
    public ResponseEntity<Void> updateTodolist(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long todolistId, @RequestBody TodolistRequest todolistRequest) {
        todolistService.updateTodolist(workspaceId, boardId, todolistId, todolistRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workspaceId}/boards/{boardId}/todolists/{todolistId}")
    public ResponseEntity<Void> removeTodolist(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long todolistId) {
        todolistService.removeTodolist(workspaceId, boardId, todolistId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{workspaceId}/boards/{boardId}/todolists/{todolistId}/toggleArchive")
    public ResponseEntity<Void> toggleTodolistIsArchive(@PathVariable Long workspaceId, @PathVariable Long boardId,
            @PathVariable Long todolistId) {
        todolistService.toggleTodolistIsArchive(workspaceId, boardId, todolistId);
        return ResponseEntity.ok().build();
    }
}
