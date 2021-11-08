package com.esm.clientelog.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;


    @NotBlank
    @Size(min = 2,max = 60)
    private String nome;

    @Email
    @NotBlank
    @Size(min = 2,max = 255)
    private String email;

    @NotBlank
    @Size(min = 2,max = 20)
    private String telefone;

    @NotBlank
    @Size(min = 2,max = 255)
    private String endereco;

    @NotBlank
    @CPF
    private String cpf;
}
