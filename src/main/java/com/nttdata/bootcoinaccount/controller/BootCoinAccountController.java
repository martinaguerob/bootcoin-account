package com.nttdata.bootcoinaccount.controller;

import com.nttdata.bootcoinaccount.entity.BootCoinAccount;
import com.nttdata.bootcoinaccount.service.BootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin-account")
public class BootCoinAccountController {

    @Autowired
    BootCoinAccountService bootCoinAccountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootCoinAccount> getBootCoinAccount(){
        return bootCoinAccountService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BootCoinAccount> saveBootCoinAccount(@RequestBody BootCoinAccount bootCoinAccount){
        return bootCoinAccountService.save(bootCoinAccount);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootCoinAccount> getBootCoinAccountById(@PathVariable String id){
        return bootCoinAccountService.findById(id);
    }
}
