package mapit.mapit.controller;

import lombok.RequiredArgsConstructor;
import mapit.mapit.model.dao.CommentEntity;
import mapit.mapit.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/add")
    public ResponseEntity<CommentEntity> addComment(@RequestBody CommentEntity comment) {
        CommentEntity newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentEntity> getCommentById(@PathVariable("id") Long id) {
        CommentEntity comment = commentService.findCommentByID(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
