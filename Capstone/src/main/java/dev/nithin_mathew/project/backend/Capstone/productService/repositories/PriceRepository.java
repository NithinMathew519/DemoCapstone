package dev.nithin_mathew.project.backend.Capstone.productService.repositories;

import dev.nithin_mathew.project.backend.Capstone.productService.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}