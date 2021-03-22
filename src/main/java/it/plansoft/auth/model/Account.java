package it.plansoft.auth.model;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Account")
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends IDModel<Long> {
    @Column(name = "sso")
    private String sso;

    @Column(name = "password")
    private String password;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
