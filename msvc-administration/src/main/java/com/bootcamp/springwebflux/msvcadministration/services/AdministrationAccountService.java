package com.bootcamp.springwebflux.msvcadministration.services;

import com.bootcamp.springwebflux.msvcadministration.models.documents.Account;
import com.msvc.specification.api.dto.AdministrativeAccountDto;
import com.msvc.specification.api.dto.NewAdministrativeAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdministrationAccountService {


    public Mono<Account> save(Account account);
    public Mono<Account> postAccount(NewAdministrativeAccountDto newAdministrativeAccountDto);

}
