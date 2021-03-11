//package it.plansoft.auth.repository;
//
//import it.plansoft.auth.model.UserAccount;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
///**
// * repo per utenti account ruoli
// * @author Giuseppe Grosso
// *
// */
//@Repository
//public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
//	Optional<UserAccount> findByName(String name);
//	Optional<UserAccount> findBySso(String sso);
//
//	Optional<UserAccount> findByAzienda(String azienda2);
//
//}