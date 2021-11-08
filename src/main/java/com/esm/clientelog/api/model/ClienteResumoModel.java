package com.esm.clientelog.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class ClienteResumoModel extends RepresentationModel<ClienteResumoModel> {

    private Long id;
    private String nome;
}
