package it.plansoft.auth.service;/* ggrosso created on 11/03/2021 inside the package - it.plansoft.auth.service */

import it.plansoft.auth.dto.RolesDto;
import it.plansoft.auth.mapper.IRolesMapper;
import it.plansoft.auth.model.Roles;
import it.plansoft.auth.repository.RolesRepository;
import it.plansoft.auth.service.interfaces.BaseCrudDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService extends BaseCrudDtoService<RolesRepository, IRolesMapper, RolesDto, Roles, Long> {

    @Autowired
    public RolesService(RolesRepository repository, IRolesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


}