package com.esm.clientelog.api.model.input;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteInput {



    @NotNull
    @Size(min = 2,max = 60)
    private String nome;

    @Email
    @NotNull
    @Size(min = 2,max = 255)
    private String email;

    @NotNull
    @Size(min = 2,max = 20)
    private String telefone;

    @NotNull
    @Size(min = 2,max = 255)
    private String endereco;

    @NotNull
    @CPF
    private String cpf;
}
