package mapit.mapit.service;

import lombok.RequiredArgsConstructor;
import mapit.mapit.exception.CommentNotFoundException;
import mapit.mapit.model.dao.CommentEntity;
import mapit.mapit.repository.CommentRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentEntity addComment(CommentEntity addComent) {
        return commentRepo.save(addComent);
    }

    public CommentEntity findCommentByID(Long id) {
        return commentRepo.findCommentById(id)
                .orElseThrow(() -> new CommentNotFoundException("Nie ma takiego id: " + id));
    }
}
