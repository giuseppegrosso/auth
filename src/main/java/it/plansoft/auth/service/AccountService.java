package it.plansoft.auth.service;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.service */

import it.plansoft.auth.dto.UserDto;
import it.plansoft.auth.mapper.IUserMapper;
import it.plansoft.auth.model.User;
import it.plansoft.auth.repository.UserRepository;
import it.plansoft.auth.service.interfaces.BaseCrudDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseCrudDtoService<UserRepository, IUserMapper, UserDto, User, Long> {

    @Autowired
    public AccountService(UserRepository repository, IUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


}