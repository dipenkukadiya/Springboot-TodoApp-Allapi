package com.example.Coder.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coder.DTO.CommentDTO;
import com.example.Coder.Entity.Comment;
import com.example.Coder.Entity.Todo;
import com.example.Coder.Entity.User;
import com.example.Coder.Repository.CommentRepo;
import com.example.Coder.Repository.TodoRepo;
import com.example.Coder.Repository.UserRepo;
import com.example.Coder.Request.CommentRequest;
import com.example.Coder.Service.CommentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TodoRepo todoRepo;

    @Override
    public List<CommentDTO> getComment() {
        List<Comment> comments = commentRepo.findAll();
        return mapCommentListToDTOList(comments);
    }

    @Override
    public List<CommentDTO> getCommentBytodoId(Long todoId) {
        List<Comment> comments = commentRepo.findByTodoId(todoId);
        return mapCommentListToDTOList(comments);
    }

    @Override
    public List<CommentDTO> getCommentByUserId(Long userId) {
        List<Comment> comments = commentRepo.findByUserId(userId);
        return mapCommentListToDTOList(comments);
    }

    @Override
    public void addComment(CommentRequest commentRequest, Long userId, Long todoId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Todo todo = todoRepo.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo not found"));

        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setUser(user);
        comment.setTodo(todo);

        commentRepo.save(comment);
    }

    @Override
    public void updateComment(CommentRequest commentRequest, Long commentId) {
        Comment existingComment = commentRepo.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        existingComment.setComment(commentRequest.getComment());

        commentRepo.save(existingComment);
    }

    @Override
    public void removeComment(Long commentId) {
        Comment comment = commentRepo.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        commentRepo.delete(comment);
    }

    // Helper method to manually map a list of Comment entities to a list of
    // CommentDTOs
    private List<CommentDTO> mapCommentListToDTOList(List<Comment> comments) {
        return comments.stream()
                .map(this::mapCommentToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to manually map a Comment entity to a CommentDTO
    private CommentDTO mapCommentToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComment(comment.getComment());
        // Assuming Todo and User entities have name fields
        commentDTO.setTodoName(comment.getTodo().getName());
        commentDTO.setUserName(comment.getUser().getUsername());
        return commentDTO;
    }
}
