package com.esm.clientelog.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontrado extends Exception{

    public ClienteNaoEncontrado(Long clienteId) {
        super(String.format("Cliente com ID %s nao encontrado", clienteId));
    }
}
