package it.plansoft.auth;

import it.plansoft.auth.model.UserAccount;
import it.plansoft.auth.repository.UserAccountRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * test repository standalone
 */
public class RepositoryTest extends AbstractRepoTest {


    @Autowired
    private UserAccountRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testStandAloneRepository() throws Exception {
        Optional<UserAccount> user = this.repository.findBySso("giuseppe");
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
