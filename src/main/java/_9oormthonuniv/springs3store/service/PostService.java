package _9oormthonuniv.springs3store.service;

import _9oormthonuniv.springs3store.dto.PostRequestDTO;
import _9oormthonuniv.springs3store.dto.PostResponseDTO;
import _9oormthonuniv.springs3store.entity.PostEntity;
import _9oormthonuniv.springs3store.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long createPost(PostRequestDTO postRequestDTO) {

        PostEntity postEntity = new PostEntity();

        postEntity.setTitle(postRequestDTO.getTitle());
        postEntity.setTitle(postRequestDTO.getContent());
        postEntity.setImageUrl(postRequestDTO.getImageUrl());

        return postRepository.save(postEntity).getId();
    }

    /*
    List<PostEntity> != List<PostResponseDTO>
    List<T>는 타입을 정확하게 따져서, T가 다르면 리스트 자체 호환이 안됨.

    PostEntity -> PostResponseDTO 변환이 가능해도 리스트 자체는 자동으로 변환이 안됨.
    -> PostEntity를 PostResponeDTO로 바꾸려면 수동으로
     */
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDTO(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getImageUrl()
                ))
                .collect(Collectors.toList());
    }
}
