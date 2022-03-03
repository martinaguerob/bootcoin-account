package com.nttdata.bootcoinaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BootCoinPurse {

    private String id;
    private Integer numberPurse; //Número de cuenta del monedero
    private Double amount; //Monto en BootCoinAccount
    private Date createdAt;
    private Boolean status;
}
