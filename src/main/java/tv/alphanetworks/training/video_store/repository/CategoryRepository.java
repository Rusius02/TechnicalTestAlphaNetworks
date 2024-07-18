package tv.alphanetworks.training.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.alphanetworks.training.video_store.model.Category;
import tv.alphanetworks.training.video_store.model.CategoryEnum;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategory(CategoryEnum category);
}
