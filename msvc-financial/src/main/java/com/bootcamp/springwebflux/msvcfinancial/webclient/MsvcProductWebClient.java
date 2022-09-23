package com.bootcamp.springwebflux.msvcfinancial.webclient;

import com.msvc.specification.api.dto.NewProductDto;
import com.msvc.specification.api.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MsvcProductWebClient {

    private Logger logger = LoggerFactory.getLogger(MsvcProductWebClient.class);

    WebClient webclient = WebClient.create("http://localhost:8080");

    public Mono<ProductDto> getProduct(String id) {
        logger.info(String.format("Calling getProduct (%s)", id));

        return webclient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class);
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
