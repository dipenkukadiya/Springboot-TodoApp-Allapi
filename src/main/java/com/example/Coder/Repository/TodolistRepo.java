package com.example.Coder.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Todo;
import com.example.Coder.Entity.Todolist;

public interface TodolistRepo extends JpaRepository<Todolist,Long>{

    List<Todolist> findByBoardId(Long boardId);

    Todolist findByIdAndBoardId(Long cardId, Long boardId);

    void deleteByIdAndBoardId(Long cardId, Long boardId);

    Optional<Todo> findByIdAndBoard_IdAndBoard_Workspace_Id(Long todolistId, Long boardId, Long workspaceId);
    Optional<Todolist> findByTodolistIndexAndBoardId(Long todolistIndex, Long boardId);

}
