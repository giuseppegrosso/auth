package it.plansoft.auth.repository;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.repository */

import it.plansoft.auth.model.Roles;
import it.plansoft.auth.model.User;
import it.plansoft.auth.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRuolo(String ruolo);
    Optional<Roles> findByUserSso(String sso);
}