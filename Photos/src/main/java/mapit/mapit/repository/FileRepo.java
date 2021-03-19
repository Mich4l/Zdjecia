package mapit.mapit.repository;

import mapit.mapit.model.dao.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileEntity, String> {

}
