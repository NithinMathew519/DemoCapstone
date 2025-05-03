package dev.nithin_mathew.project.backend.Capstone.productService.repositories;

import dev.nithin_mathew.project.backend.Capstone.productService.models.Product;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
@Registered
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
