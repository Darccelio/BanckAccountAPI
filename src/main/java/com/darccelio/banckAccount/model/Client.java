package com.darccelio.banckAccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can't be empty.0")
    @Column(name = "nameClient", nullable = false, length = 255)
    private String name;

    @CPF
    @NotEmpty(message = "CPF is mandatory.")
    @Column(name="cpf", nullable = false, length = 11)
    private String cpf;

    @ManyToMany
    private Set<Account> accounts;


}
