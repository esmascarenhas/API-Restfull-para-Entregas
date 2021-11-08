package com.esm.clientelog.utils;

import com.esm.clientelog.api.model.ClienteModel;
import com.esm.clientelog.domain.entity.Cliente;

public class ClienteUtils {

    private static final long CLIENTE_ID = 1L;
    private static final String NOME = "Emerson";
    private static final String EMAIL = "esm@gmail.com";
    private static final String TELEFONE = "71988552254";
    private static final String ENDERECO = "Cabula";
    private static final String CPF = "928373795-49";

    public static ClienteModel createFakeModel(){
        return ClienteModel.builder()
                .nomeCliente(NOME)
                .emailCliente(EMAIL)
                .enderecoCliente(ENDERECO)
                .telefoneCliente(TELEFONE)
                .cpfCliente(CPF)
                .build();
    }
    public static Cliente createFakeEntity(){
        return Cliente.builder()
                .id(CLIENTE_ID)
                .nome(NOME)
                .email(EMAIL)
                .telefone(TELEFONE)
                .endereco(ENDERECO)
                .cpf(CPF)
                .build();
    }
}
