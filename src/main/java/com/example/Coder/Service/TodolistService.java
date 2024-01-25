package com.example.Coder.Service;

import java.util.List;


import com.example.Coder.DTO.TodolistDTO;

import com.example.Coder.Request.TodolistRequest;

public interface TodolistService {
    List<TodolistDTO> getAllTodolistByWIdndBId(Long workspaceId,Long boardId);

    TodolistDTO getTodolistByid(Long workspaceId, Long boardId,Long todolistId);

    void addTodolist(Long workspaceId,Long boardId, TodolistRequest todolistRequest);

    void updateTodolist(Long workspaceId, Long boardId,Long todolistId, TodolistRequest todolistRequest);

    void removeTodolist(Long workspaceId, Long boardId ,Long todolistId);

    void toggleTodolistIsArchive(Long workspaceId, Long boardId ,Long todolistId);

    
    
}
