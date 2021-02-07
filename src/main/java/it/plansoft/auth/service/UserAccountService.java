package it.plansoft.auth.service;

import it.plansoft.auth.model.UserAccount;
import it.plansoft.auth.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * classe di gestione della tabella userAccount
 */
@Service
public class UserAccountService extends BaseCrudService<UserAccountRepository, UserAccount, Long> {

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        super(userAccountRepository);
    }


}