package _9oormthonuniv.springs3store.domain.post.service;

import _9oormthonuniv.springs3store.domain.post.dto.PostRequestDTO;
import _9oormthonuniv.springs3store.domain.post.dto.PostResponseDTO;
import _9oormthonuniv.springs3store.domain.post.entity.PostEntity;
import _9oormthonuniv.springs3store.domain.post.repository.PostRepository;
import _9oormthonuniv.springs3store.global.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // AwsS3Service 주입
    private final AwsS3Service awsS3Service;

    public Long createPost(PostRequestDTO postRequestDTO, MultipartFile image) {

        String imageUrl = awsS3Service.uploadFile(image);

        PostEntity postEntity = new PostEntity();

        postEntity.setTitle(postRequestDTO.getTitle());
        postEntity.setContent(postRequestDTO.getContent());
        postEntity.setImageUrl(imageUrl);

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
