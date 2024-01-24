package com.example.Coder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Comment;


public interface CommentRepo extends JpaRepository<Comment , Long> {

    List<Comment> findByTodoId(Long todoId);

    List<Comment> findByUserId(Long userId);
    
}
