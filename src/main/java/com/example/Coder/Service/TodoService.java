package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.TodoDTO;
import com.example.Coder.Request.TodoRequest;

public interface TodoService {

    List<TodoDTO> getAllTodosByWBTId(Long workspaceId, Long boardId, Long todolistId);

    TodoDTO getTodoByWBTIdAndTodoId(Long workspaceId, Long boardId, Long todolistId, Long todoId);

    void addTodo(Long workspaceId, Long boardId, Long todolistId, TodoRequest todoRequest);

    void updateTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId, TodoRequest todoRequest);

    void removeTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId);

    void archiveTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId);
}
