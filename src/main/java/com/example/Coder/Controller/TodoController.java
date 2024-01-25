package com.example.Coder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Coder.DTO.TodoDTO;
import com.example.Coder.Request.TodoRequest;
import com.example.Coder.Service.TodoService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/workspaces/{workspaceId}/boards/{boardId}/todolists/{todolistId}/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodosByWBTId(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId) {
        List<TodoDTO> todos = todoService.getAllTodosByWBTId(workspaceId, boardId, todolistId);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDTO> getTodoByWBTIdAndTodoId(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId,
            @PathVariable Long todoId) {
        TodoDTO todoDTO = todoService.getTodoByWBTIdAndTodoId(workspaceId, boardId, todolistId, todoId);
        if (todoDTO != null) {
            return ResponseEntity.ok(todoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addTodo(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId,
            @RequestBody TodoRequest todoRequest) {
        todoService.addTodo(workspaceId, boardId, todolistId, todoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Void> updateTodo(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId,
            @PathVariable Long todoId,
            @RequestBody TodoRequest todoRequest) {
        try {
            todoService.updateTodo(workspaceId, boardId, todolistId, todoId, todoRequest);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> removeTodo(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId,
            @PathVariable Long todoId) {
        todoService.removeTodo(workspaceId, boardId, todolistId, todoId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{todoId}/archive")
    public ResponseEntity<Void> archiveTodo(
            @PathVariable Long workspaceId,
            @PathVariable Long boardId,
            @PathVariable Long todolistId,
            @PathVariable Long todoId) {
        try {
            todoService.archiveTodo(workspaceId, boardId, todolistId, todoId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
