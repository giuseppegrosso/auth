package it.plansoft.auth.controller;


import it.plansoft.auth.controller.interfaces.BaseCrudDtoController;
import it.plansoft.auth.dto.UserDto;
import it.plansoft.auth.mapper.IUserMapper;
import it.plansoft.auth.model.User;
import it.plansoft.auth.repository.UserRepository;
import it.plansoft.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAccount")
public class UserAccountController extends BaseCrudDtoController<UserService, UserRepository, IUserMapper, UserDto, User, Long> {

    @Autowired
    public UserAccountController(UserService service) {
        super(service);
    }


    @PutMapping("/disable/{id}")
    public UserDto update(@RequestBody UserDto dto, @PathVariable Long id) {

        UserDto user = service.findById(id);
        if (user == null) throw new RuntimeException("user non trovato");

        dto.setId(id);
        dto.setExpired(true);
        return service.save(dto);
    }

}