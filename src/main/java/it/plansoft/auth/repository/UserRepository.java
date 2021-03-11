package it.plansoft.auth.repository;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.repository */

import it.plansoft.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNome(String nome);
//    Optional<UserAccount> findByAzienda(String azienda2);
}