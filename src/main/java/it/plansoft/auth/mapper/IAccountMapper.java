package it.plansoft.auth.mapper;

import it.plansoft.auth.dto.AccountDto;
import it.plansoft.auth.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAccountMapper extends IMapper<AccountDto, Account> {

}