package com.nttdata.bootcoinaccount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "bootcoin-account")
public class BootCoinAccount {

    @Id
    private String id;
    private String typeDoc;
    private String numberDoc;
    private String celphone;
    private String email;
    private Integer numberPurse; //Número de cuenta del monedero
    private String linkedAccount; //cuenta vinculada
    private String numberBankAccount; // número de cuenta bancaria si tiene
    private Boolean status;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;

}
