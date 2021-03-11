package it.plansoft.auth.controller;


import it.plansoft.auth.controller.interfaces.BaseCrudController;
import it.plansoft.auth.model.UserAccount;
import it.plansoft.auth.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/userAccount")
public class UserAccountController extends BaseCrudController<UserAccountService, UserAccount, Long> {

    @Autowired
    public UserAccountController(UserAccountService service) {
        super(service);
    }


    @PutMapping("/disable/{id}")
    public UserAccount update(@RequestBody UserAccount model, @PathVariable Long id) {

        return (UserAccount) service.getById(id).map(Item -> {
            model.setId(id);
            model.setExpired(true);
            return service.save(model);
        }).orElseThrow(() -> new RuntimeException("user non trovato"));
    }

}