package _9oormthonuniv.springs3store.domain.post.controller;

import _9oormthonuniv.springs3store.domain.post.dto.PostRequestDTO;
import _9oormthonuniv.springs3store.domain.post.dto.PostResponseDTO;
import _9oormthonuniv.springs3store.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createPost(
            @RequestPart("postRequestDTO") PostRequestDTO postRequestDTO,
            @RequestPart("image") MultipartFile image
            )
    {
        Long postId = postService.createPost(postRequestDTO, image);
        return ResponseEntity.ok(postId);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePost(
            @PathVariable Long id,
            @RequestPart PostRequestDTO postRequestDTO,
            @RequestPart(required = false) MultipartFile image)
    {
        Long updateId = postService.updatePost(id, postRequestDTO, image);
        return ResponseEntity.ok(updateId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
