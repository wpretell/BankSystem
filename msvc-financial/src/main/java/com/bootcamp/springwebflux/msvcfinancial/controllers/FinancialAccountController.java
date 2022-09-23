package com.bootcamp.springwebflux.msvcfinancial.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.bootcamp.springwebflux.msvcfinancial.mapper.FinancialMapper;
import com.bootcamp.springwebflux.msvcfinancial.services
    .FinancialAccountService;
import com.msvc.specification.api.FinantialApi;
import com.msvc.specification.api.dto.AccountDto;
import com.msvc.specification.api.dto.MovementDto;

import reactor.core.publisher.Mono;

@RestController
public class FinancialAccountController implements FinantialApi {

    @Autowired
    private FinancialAccountService financialAccountService;

    @Autowired
    private FinancialMapper financialMapper;

    @Override
    public Mono<ResponseEntity<AccountDto>> balanceAccount(String arg0,
        @Valid Mono<AccountDto> accountDto,
            ServerWebExchange arg2) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<AccountDto>> balanceCredit(String arg0,
        @Valid Mono<AccountDto> arg1,
            ServerWebExchange arg2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<ResponseEntity<AccountDto>> movement(String id,
        @Valid Mono<MovementDto> movementDto,
            ServerWebExchange arg2) {
        return movementDto.flatMap(movement -> financialAccountService.save(id, financialMapper.toModel(movement))
            .map(account ->
                ResponseEntity.created(URI.create("/administrative/accounts/".concat(id)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(account)));
        // return null;
    }

    @Override
    public Mono<ResponseEntity<AccountDto>> movementCredit(String arg0, @Valid Mono<MovementDto> arg1,
            ServerWebExchange arg2) {
        // TODO Auto-generated method stub
        return null;
    }
}
