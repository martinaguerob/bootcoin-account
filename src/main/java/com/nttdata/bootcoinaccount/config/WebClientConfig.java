package com.nttdata.bootcoinaccount.config;

import com.nttdata.bootcoinaccount.model.BootCoinPurse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    private final WebClient.Builder webClientBuilder = WebClient.builder();

    public Mono<BootCoinPurse> saveBootCoinPurse(BootCoinPurse bootCoinPurse){
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:8080/bootcoin-purse")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bootCoinPurse))
                .retrieve()
                .bodyToMono(BootCoinPurse.class);
    }
}
