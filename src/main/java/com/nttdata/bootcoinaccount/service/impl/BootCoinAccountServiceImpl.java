package com.nttdata.bootcoinaccount.service.impl;

import com.nttdata.bootcoinaccount.config.WebClientConfig;
import com.nttdata.bootcoinaccount.entity.BootCoinAccount;
import com.nttdata.bootcoinaccount.model.BootCoinPurse;
import com.nttdata.bootcoinaccount.repository.BootCoinAccountRepository;
import com.nttdata.bootcoinaccount.service.BootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Random;

@Service
public class BootCoinAccountServiceImpl implements BootCoinAccountService {

    @Autowired
    BootCoinAccountRepository bootCoinAccountRepository;
    private final WebClientConfig webClientConfig = new WebClientConfig();

    @Override
    public Flux<BootCoinAccount> findAll() {
        return bootCoinAccountRepository.findAll();
    }

    @Override
    public Mono<BootCoinAccount> save(BootCoinAccount entity) {
        int valRandom = this.rand();
        entity.setNumberPurse(valRandom);
        entity.setCreatedAt(new Date());
        entity.setStatus(true);
        entity.setLinkedAccount(entity.getLinkedAccount()==null ? " " : entity.getLinkedAccount());
        entity.setNumberBankAccount(entity.getNumberBankAccount()==null ? " " : entity.getNumberBankAccount());
        this.createdPurse(valRandom).subscribe();
        return bootCoinAccountRepository.save(entity);
    }

    @Override
    public Mono<BootCoinAccount> update(BootCoinAccount entity, String id) {
        return  bootCoinAccountRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    entity.setCelphone(entity.getCelphone()==null ? origin.getCelphone() : entity.getCelphone());
                    entity.setTypeDoc(entity.getTypeDoc()==null ? origin.getTypeDoc() : entity.getTypeDoc());
                    entity.setNumberDoc(entity.getNumberDoc()==null ? origin.getNumberDoc() : entity.getNumberDoc());
                    entity.setEmail(entity.getEmail()==null ? origin.getEmail() : entity.getEmail());
                    entity.setNumberPurse(entity.getNumberPurse()==null ? origin.getNumberPurse() : entity.getNumberPurse());
                    entity.setLinkedAccount(entity.getLinkedAccount()==null ? origin.getLinkedAccount() : entity.getLinkedAccount());
                    entity.setNumberBankAccount(entity.getNumberBankAccount()==null ? origin.getNumberBankAccount() : entity.getNumberBankAccount());
                    return bootCoinAccountRepository.save(origin);
                });
    }

    @Override
    public Mono<BootCoinAccount> deleteById(String id) {
        return bootCoinAccountRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return bootCoinAccountRepository.save(origin);
                });
    }

    public int rand(){
        int start = 100;
        int end = 2147483647;
        int random = new Random().nextInt();
        int result = start+(random*(end-start));
        return result;
    }

    public Mono<BootCoinPurse>createdPurse(int numberPurse){
        BootCoinPurse bootCoinPurse = new BootCoinPurse();
        bootCoinPurse.setNumberPurse(numberPurse);
        return webClientConfig.saveBootCoinPurse(bootCoinPurse);
    }

    @Override
    public Mono<BootCoinAccount> findById(String id) {
        return bootCoinAccountRepository.findById(id);
    }
}
