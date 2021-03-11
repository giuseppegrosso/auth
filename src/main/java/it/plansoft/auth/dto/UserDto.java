package it.plansoft.auth.dto;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth */

import it.plansoft.auth.model.Account;
import it.plansoft.auth.model.IDModel;
import it.plansoft.auth.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends IDModel<Long> {

    private String cognome;
    private String nome;
    private String email;
    private String azienda;

    private Account account;

    private List<Roles> roles;

    private Boolean locked;

    private Boolean enabled;

    private Boolean expired;
}
