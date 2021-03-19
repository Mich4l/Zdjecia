package mapit.mapit.repository;

import mapit.mapit.model.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {

    @Override
    List<PostEntity> findAll();

    Optional<PostEntity> findPostById(Long id);

    void deletePostById(Long id);
}
