package mapit.mapit.service;

import lombok.RequiredArgsConstructor;
import mapit.mapit.exception.PostNotFoundException;
import mapit.mapit.model.dao.PostEntity;
import mapit.mapit.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public PostEntity addPost(PostEntity addPost) {
        return postRepo.save(addPost);
    }

    public List<PostEntity> findAllPosts() {
        return postRepo.findAll();
    }

    public PostEntity updatePost(PostEntity post) {
        return postRepo.save(post);
    }

    public PostEntity findPostById(Long id) {
        return postRepo.findPostById(id)
                .orElseThrow(() -> new PostNotFoundException("Nie ma posta o id: " + id));
    }

    public void deletePost(Long id) {
        postRepo.deletePostById(id);
    }
}
