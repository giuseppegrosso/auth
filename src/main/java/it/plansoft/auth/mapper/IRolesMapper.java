package it.plansoft.auth.mapper;

import it.plansoft.auth.dto.RolesDto;
import it.plansoft.auth.dto.UserDto;
import it.plansoft.auth.model.Roles;
import it.plansoft.auth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRolesMapper extends IMapper<RolesDto, Roles> {

}