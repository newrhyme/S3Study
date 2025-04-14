package _9oormthonuniv.springs3store.domain.post.repository;

import _9oormthonuniv.springs3store.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
