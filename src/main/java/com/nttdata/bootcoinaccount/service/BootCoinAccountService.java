package com.nttdata.bootcoinaccount.service;

import com.nttdata.bootcoinaccount.entity.BootCoinAccount;
import reactor.core.publisher.Mono;

public interface BootCoinAccountService extends CrudService<BootCoinAccount, String> {

    Mono<BootCoinAccount> findById(String id);
}
