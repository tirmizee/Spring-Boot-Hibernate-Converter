package com.tirmizee.entities;

import com.tirmizee.components.EncryptDecryptConverter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = EncryptDecryptConverter.class)
    @Column(name = "cid")
    private String cid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Convert(converter = EncryptDecryptConverter.class)
    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "email")
    private String email;

}
