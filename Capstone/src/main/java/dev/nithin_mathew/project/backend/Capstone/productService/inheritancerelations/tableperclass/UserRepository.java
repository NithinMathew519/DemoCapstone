package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.tableperclass;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);
}
