package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Ta")
public class Ta extends User {
    private String ta_session;
}
