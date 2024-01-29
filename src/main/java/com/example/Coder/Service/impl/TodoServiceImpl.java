package com.example.Coder.Service.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Coder.DTO.TodoDTO;

import com.example.Coder.Entity.Todo;
import com.example.Coder.Entity.Todolist;
import com.example.Coder.Entity.User;

import com.example.Coder.Repository.TodoRepo;
import com.example.Coder.Repository.TodolistRepo;
import com.example.Coder.Repository.UserRepo;
import com.example.Coder.Request.TodoRequest;
import com.example.Coder.Service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TodolistRepo todolistRepo;

    @Override
    public List<TodoDTO> getAllTodosByWBTId(Long workspaceId, Long boardId, Long todolistId) {
        List<Todo> todos = todoRepo.findByTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(
                todolistId, boardId, workspaceId);
        return todos.stream().map(this::convertToTodoDTO).collect(Collectors.toList());
    }

    @Override
    public TodoDTO getTodoByWBTIdAndTodoId(Long workspaceId, Long boardId, Long todolistId, Long todoId) {
        Optional<Todo> todoOptional = todoRepo.findByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(
                todoId, todolistId, boardId, workspaceId);
        return todoOptional.map(this::convertToTodoDTO).orElse(null);
    }

    @Override
    @Transactional
    public void addTodo(Long workspaceId, Long boardId, Long todolistId, TodoRequest todoRequest) {
        Todo todo = convertToTodoEntity(workspaceId, boardId, todolistId, todoRequest);
        User createdByUser = userRepo.findById(todoRequest.getCreatedById())
                .orElseThrow(() -> new RuntimeException("User not found"));

        todo.setCreatedBy(createdByUser);

        Set<User> assignedToUsers = todoRequest.getAssignedToIds().stream()
                .map(userId -> userRepo.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Assigned user not found")))
                .collect(Collectors.toSet());

        todo.setAssignees(assignedToUsers);

        todoRepo.save(todo);
    }

    @Override
    @Transactional
    public void updateTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId, TodoRequest todoRequest) {
        Todo todo = todoRepo.findByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(
                todoId, todolistId, boardId, workspaceId).orElseThrow(() -> new RuntimeException("Todo not found"));

        System.out.println("hello bludy");
        todo.setName(todoRequest.getName());
        todo.setDescription(todoRequest.getDescription());
        todo.setTodoKey(todoRequest.getTodoKey());
        todo.setIsArchived(todoRequest.getIsArchived());

        Set<User> assignees = new HashSet<>();

        if (todoRequest.getAssignedToIds() != null) {
            for (Long assignedToId : todoRequest.getAssignedToIds()) {
                User assignedToUser = userRepo.findById(assignedToId)
                        .orElseThrow(() -> new RuntimeException("Assigned user not found"));
                assignees.add(assignedToUser);
            }
        }

        todo.setAssignees(assignees);

        todoRepo.save(todo);
    }

    @Override
    @Transactional
    public void removeTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId) {
        todoRepo.deleteByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(
                todoId, todolistId, boardId, workspaceId);
    }

    @Override
    @Transactional
    public void archiveTodo(Long workspaceId, Long boardId, Long todolistId, Long todoId) {
        Todo todo = todoRepo.findByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(
                todoId, todolistId, boardId, workspaceId).orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setIsArchived(!todo.getIsArchived());

        todoRepo.save(todo);
    }

    private TodoDTO convertToTodoDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setName(todo.getName());
        todoDTO.setDescription(todo.getDescription());
        todoDTO.setTodoKey(todo.getTodoKey());
        todoDTO.setIsArchived(todo.getIsArchived());
        todoDTO.setTodolistId(todo.getTodolist().getId());
        LocalDateTime currentDateTime = LocalDateTime.now();

        todoDTO.setCreatedDate(currentDateTime);
        todoDTO.setUpdatedDate(currentDateTime);

        return todoDTO;
    }

    private Todo convertToTodoEntity(Long workspaceId, Long boardId, Long todolistId, TodoRequest todoRequest) {
        Todo todo = new Todo();
        Todolist todolist = todolistRepo.findById(todolistId).orElse(null);

        todo.setName(todoRequest.getName());
        todo.setDescription(todoRequest.getDescription());
        todo.setTodoKey(todoRequest.getTodoKey());
        todo.setIsArchived(todoRequest.getIsArchived());
        todo.setTodolist(todolist);
        LocalDateTime currentDateTime = LocalDateTime.now();

        todo.setCreatedDate(currentDateTime);
        todo.setUpdatedDate(currentDateTime);
        return todo;
    }
}
