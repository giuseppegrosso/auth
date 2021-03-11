package it.plansoft.auth.repository;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.repository */

import it.plansoft.auth.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findBySso(String sso);
}