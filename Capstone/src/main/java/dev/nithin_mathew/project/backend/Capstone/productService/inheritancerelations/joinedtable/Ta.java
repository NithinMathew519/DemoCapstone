package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_Ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class Ta extends User {
    private String ta_session;
}
