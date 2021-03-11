package it.plansoft.auth.dto;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth */

import it.plansoft.auth.model.IDModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesDto extends IDModel<Long> {

    private String ruolo;
}
