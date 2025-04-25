package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_tarepository")
public interface TaRepository extends JpaRepository<Ta,Long> {
    @Override
    <S extends Ta> S save(S entity);
}
