package _9oormthonuniv.springs3store.domain.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;

    public PostResponseDTO(Long id, String title, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
