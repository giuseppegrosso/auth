package it.plansoft.auth.dto;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth */

import it.plansoft.auth.model.Account;
import it.plansoft.auth.model.IDModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto extends IDModel<Long> {

    private String sso;
    private String password;
}
