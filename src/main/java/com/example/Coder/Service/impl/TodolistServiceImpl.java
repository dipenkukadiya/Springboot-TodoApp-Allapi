package com.example.Coder.Service.impl;

import com.example.Coder.DTO.TodolistDTO;
import com.example.Coder.Entity.Board;
import com.example.Coder.Entity.Todolist;
import com.example.Coder.Repository.TodolistRepo;
import com.example.Coder.Repository.BoardRepo;
import com.example.Coder.Service.TodolistService;
import com.example.Coder.Request.TodolistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodolistServiceImpl implements TodolistService {

    @Autowired
    private TodolistRepo todolistRepo;

    @Autowired
    private BoardRepo boardRepo;

    @Override
    public List<TodolistDTO> getAllTodolistByWIdndBId(Long workspaceId, Long boardId) {
        List<Todolist> todolists = todolistRepo.findByBoardId(boardId);
        return convertTodolistsToDTOs(todolists);
    }

    @Override
    public TodolistDTO getTodolistByid(Long workspaceId, Long boardId, Long todolistId) {
        Todolist todolist = todolistRepo.findByIdAndBoardId(todolistId, boardId);
        return convertTodolistToDTO(todolist);
    }

    @Override
    public void addTodolist(Long workspaceId, Long boardId, TodolistRequest todolistRequest) {
        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Todolist todolist = new Todolist();
            todolist.setName(todolistRequest.getName());
            todolist.setTodolistIndex(todolistRequest.getTodolistIndex());
            todolist.setTodolistKey(todolistRequest.getTodolistKey());
            todolist.setIsArchive(todolistRequest.getIsArchive());
            todolist.setBoard(board);
            todolistRepo.save(todolist);
        }
    }

    @Override
    public void updateTodolist(Long workspaceId, Long boardId, Long todolistId, TodolistRequest todolistRequest) {

        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Todolist todolist = todolistRepo.findByIdAndBoardId(todolistId, boardId);
            if (todolist != null) {
                todolist.setName(todolistRequest.getName());
                todolist.setTodolistIndex(todolistRequest.getTodolistIndex());
                todolist.setTodolistKey(todolistRequest.getTodolistKey());
                todolist.setIsArchive(todolistRequest.getIsArchive());
                todolist.setBoard(board);
                todolistRepo.save(todolist);
            }
        }
    }

    @Override
    public void removeTodolist(Long workspaceId, Long boardId, Long todolistId) {

        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            todolistRepo.deleteById(todolistId);
        }
    }

    @Override
    public void toggleTodolistIsArchive(Long workspaceId, Long boardId, Long todolistId) {

        Board board = boardRepo.findById(boardId).orElse(null);
        if (board != null) {
            Todolist todolist = todolistRepo.findByIdAndBoardId(todolistId, boardId);
            if (todolist != null) {
                todolist.setIsArchive(!todolist.getIsArchive());
                todolistRepo.save(todolist);
            }
        }
    }

    private List<TodolistDTO> convertTodolistsToDTOs(List<Todolist> todolists) {
        return todolists.stream()
                .map(this::convertTodolistToDTO)
                .collect(Collectors.toList());
    }

    private TodolistDTO convertTodolistToDTO(Todolist todolist) {
        TodolistDTO todolistDTO = new TodolistDTO();
        todolistDTO.setId(todolist.getId());
        todolistDTO.setName(todolist.getName());
        todolistDTO.setTodolistKey(todolist.getTodolistKey());
        todolistDTO.setTodolistIndex(todolist.getTodolistIndex());
        todolistDTO.setIsArchive(todolist.getIsArchive());
        todolistDTO.setBoardId(todolist.getBoard().getId());

        return todolistDTO;
    }
}
