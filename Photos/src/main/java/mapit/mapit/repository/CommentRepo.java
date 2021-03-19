package mapit.mapit.repository;

import mapit.mapit.model.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepo extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findCommentById(Long id);
}
