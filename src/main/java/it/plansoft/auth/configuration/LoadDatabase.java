package it.plansoft.auth.configuration;

import it.plansoft.auth.model.UserAccount;
import it.plansoft.auth.repository.UserAccountRepository;
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
            UserAccountRepository uaccount,
            PasswordEncoder passwordEncoder) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                // caricamento utenti/account/ruoli
                // ..
//                log.info("insert userAccount {} ", uaccount.save(new UserAccount("Grosso", "Giuseppe",
//                        "giuseppe.ing.grosso@gmail.com", "Microsoft", "giuseppe", passwordEncoder.encode("giuseppe"), "ADMIN|READ|WRITE")));
//                log.info("insert userAccount {} ", uaccount.save(new UserAccount("Grosso", "Lorenzo",
//                        "giuseppe.ing.grosso@gmail.com", "Google", "lorenzo", passwordEncoder.encode("lorenzo"), "USER|READ")));
//                log.info("insert userAccount {} ", uaccount.save(new UserAccount("Grosso", "Daniele",
//                        "giuseppe.ing.grosso@gmail.com", "Linkedin", "daniele", passwordEncoder.encode("daniele"), "VISUALIZZATORE|READ")));
            }
        };

    }
}