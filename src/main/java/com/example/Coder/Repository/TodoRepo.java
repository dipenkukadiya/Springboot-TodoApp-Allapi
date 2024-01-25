package com.example.Coder.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

    List<Todo> findByTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(Long todolistId, Long boardId,
            Long workspaceId);

    Optional<Todo> findByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(Long todoId,
            Long todolistId, Long boardId, Long workspaceId);

    void deleteByIdAndTodolist_IdAndTodolist_Board_IdAndTodolist_Board_Workspace_Id(Long todoId, Long todolistId,
            Long boardId, Long workspaceId);

}
