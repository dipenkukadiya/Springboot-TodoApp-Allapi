package com.example.Coder.Service;

import java.util.List;

import com.example.Coder.DTO.CommentDTO;

import com.example.Coder.Request.CommentRequest;

public interface CommentService {

    List<CommentDTO> getComment();

    CommentDTO getCommentBytodoId(Long todoId);

    CommentDTO getCommentByUserId(Long UserId);

    void addComment(CommentRequest commentRequest ,Long userId ,Long todoId);

    void updateComment(CommentRequest commentRequest, Long commentId);

    void removeComment(Long commentId);

}
