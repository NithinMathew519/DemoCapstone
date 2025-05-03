package dev.nithin_mathew.project.backend.Capstone.productService.repositories;

import dev.nithin_mathew.project.backend.Capstone.productService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
