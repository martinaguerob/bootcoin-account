package com.nttdata.bootcoinaccount.repository;

import com.nttdata.bootcoinaccount.entity.BootCoinAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BootCoinAccountRepository extends ReactiveMongoRepository<BootCoinAccount, String> {
}
