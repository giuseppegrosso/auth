package it.plansoft.auth.service;

import it.plansoft.auth.model.Account;
import it.plansoft.auth.model.User;
import it.plansoft.auth.repository.AccountRepository;
import it.plansoft.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceProvider implements UserDetailsService {
//    private UserAccountRepository uRepo;

    private AccountRepository aRepo;
    private UserRepository uRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> opAccount = aRepo.findBySso(username);
        Optional<User> opUser = uRepo.findById(opAccount.get().getUser().getId());


//        if (opAccount == null || opAccount.get() == null)
//            throw new UsernameNotFoundException(MessageFormat.format("User with name {0} not found", username));

//        UserAccount userAccount = new UserAccount();
//        userAccount.setAccount(opAccount.get());
//        userAccount.setUser(opUser.get());

        return opUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with name {0} not found", username)));
    }

}
