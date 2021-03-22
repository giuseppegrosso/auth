package it.plansoft.auth.configuration;

import it.plansoft.auth.model.Account;
import it.plansoft.auth.model.User;
import it.plansoft.auth.repository.AccountRepository;
import it.plansoft.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * caricamento iniziale database.
 */
@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner LoadDatabaseTest(
            UserRepository userRepository,
            AccountRepository accountRepository,
            PasswordEncoder passwordEncoder) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                // caricamento utenti/account/ruoli
                // ..
                if (accountRepository.findBySso("giuseppe") == null) {
                    User user = userRepository.save(User.builder().cognome("Grosso").nome("Giuseppe")
                            .email("giuseppe.ing.grosso@gmail.com").azienda("Microsoft")
                            .enabled(true)
                            .expired(false)
                            .locked(false)
                            .build());

                    accountRepository.save(Account.builder().password(passwordEncoder.encode("giuseppe"))
                            .sso("giuseppe").user(user).build()
                    );
                }
            }
        };

    }
}