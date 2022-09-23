package com.bootcamp.springwebflux.msvcfinancial.webclient;

import com.msvc.specification.api.dto.AdministrativeAccountDto;
import com.msvc.specification.api.dto.NewProductDto;
import com.msvc.specification.api.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MsvcAdministrativeWebClient {

    Logger logger = LoggerFactory.getLogger(MsvcProductWebClient.class);

    WebClient webclient = WebClient.create("http://localhost:8080");

    public Mono<AdministrativeAccountDto> getAccount(String id) {
        logger.info(String.format("Calling getAccount (%s)", id));

        return webclient.get()
                .uri("/administrative/accounts/{id}", id)
                .retrieve()
                .bodyToMono(AdministrativeAccountDto.class);
    }

    public Mono<ProductDto> postProduct(NewProductDto newProductDto) {
        logger.info(String.format("Calling postProduct (%s)", newProductDto));

        return webclient.post()
                .uri("/products")
                .body(Mono.just(newProductDto), NewProductDto.class)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }

}
