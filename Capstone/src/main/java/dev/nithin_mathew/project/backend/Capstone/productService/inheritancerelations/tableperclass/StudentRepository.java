package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.tableperclass;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);
}
