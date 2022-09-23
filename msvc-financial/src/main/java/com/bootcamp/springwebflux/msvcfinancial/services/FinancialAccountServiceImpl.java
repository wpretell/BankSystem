package com.bootcamp.springwebflux.msvcfinancial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.springwebflux.msvcfinancial.models.documents.Movement;
import com.bootcamp.springwebflux.msvcfinancial.repository.MovementRepository;
import com.bootcamp.springwebflux.msvcfinancial.webclient.MsvcAdministrativeWebClient;
import com.msvc.specification.api.dto.AccountDto;

import reactor.core.publisher.Mono;

@Service
public class FinancialAccountServiceImpl implements FinancialAccountService {

    Logger logger = LoggerFactory.getLogger(FinancialAccountServiceImpl.class);

    @Autowired
    private MovementRepository movementRepository;
    
    @Autowired
    private MsvcAdministrativeWebClient msvcAdministrativeClient;

    @Override
    public Mono<AccountDto> save(String id, Movement movement) {
        logger.info("save(Movements getAccountId): " + id);
        movement.setAccountId(id);
        return movementRepository.save(movement)
            .then(msvcAdministrativeClient.getAccount(id))
            .map(account -> {
                AccountDto accountDto = new AccountDto();
                accountDto.setBalance(account.getBalance());
                return accountDto;
            });
    }
}
