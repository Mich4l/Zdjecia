package mapit.mapit.controller;

import lombok.RequiredArgsConstructor;
import mapit.mapit.model.dao.PostEntity;
import mapit.mapit.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/addpost")
    public ResponseEntity<PostEntity> addPost(@RequestBody PostEntity post) {
        PostEntity newPost = postService.addPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping("/posts")
        public ResponseEntity<List<PostEntity>> getAllPosts() {
        List<PostEntity> posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostEntity> getPostByID(@PathVariable("id") Long id) {
        PostEntity post = postService.findPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PostMapping("/posts/update")
    public ResponseEntity<PostEntity> updatePost(@RequestBody PostEntity post) {
        PostEntity updatePost = postService.updatePost(post);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/posts/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
