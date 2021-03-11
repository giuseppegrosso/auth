package it.plansoft.auth;

import it.plansoft.auth.model.Account;
import it.plansoft.auth.repository.AccountRepository;
import it.plansoft.auth.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;


/**
 * test repository standalone
 */
public class RepositoryTest extends AbstractRepoTest {


    @Autowired
    private UserRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testStandAloneRepository() throws Exception {
        Optional<Account> user = this.accountRepository.findBySso("giuseppe");
        assertEquals(user.get().getUser().getNome(), "Giuseppe");
        assertEquals(user.get().getUser().getAzienda(), "Microsoft");
    }

    @Override
    protected void loadDataBase() {
//        this.repository.save(new UserAccount("Grosso", "Giuseppe",
//                "giuseppe.ing.grosso@gmail.com", "Microsoft", "giuseppe", passwordEncoder.encode("giuseppe"), "ADMIN|READ|WRITE"));
//
    }
}
