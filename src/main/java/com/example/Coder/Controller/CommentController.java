package com.example.Coder.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coder.DTO.CommentDTO;
import com.example.Coder.Request.CommentRequest;
import com.example.Coder.Service.CommentService;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments() {
        List<CommentDTO> comments = commentService.getComment();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/todo/{todoId}")
    public ResponseEntity<CommentDTO> getCommentByTodoId(@PathVariable Long todoId) {
        CommentDTO comment = commentService.getCommentByUserId(todoId);
        return comment != null ?
                new ResponseEntity<>(comment, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CommentDTO> getCommentByUserId(@PathVariable Long userId) {
        CommentDTO comment = commentService.getCommentByUserId(userId);
        return comment != null ?
                new ResponseEntity<>(comment, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add/{userId}/{todoId}")
    public ResponseEntity<Void> addComment(@RequestBody CommentRequest commentRequest,
                                          @PathVariable Long userId,
                                          @PathVariable Long todoId) {
        commentService.addComment(commentRequest, userId, todoId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<Void> updateComment(@RequestBody CommentRequest commentRequest,
                                             @PathVariable Long commentId) {
        commentService.updateComment(commentRequest, commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentId}")
    public ResponseEntity<Void> removeComment(@PathVariable Long commentId) {
        commentService.removeComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
