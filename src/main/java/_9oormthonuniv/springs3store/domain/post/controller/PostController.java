package _9oormthonuniv.springs3store.domain.post.controller;

import _9oormthonuniv.springs3store.domain.post.dto.PostRequestDTO;
import _9oormthonuniv.springs3store.domain.post.dto.PostResponseDTO;
import _9oormthonuniv.springs3store.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        Long postId = postService.createPost(postRequestDTO);
        return ResponseEntity.ok(postId);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
