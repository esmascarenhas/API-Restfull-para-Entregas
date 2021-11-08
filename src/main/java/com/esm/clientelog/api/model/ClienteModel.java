package com.esm.clientelog.api.model;


import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Relation(collectionRelation = "Relação de Clientes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel extends RepresentationModel<ClienteModel>implements Serializable {


    private Long id;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String enderecoCliente;
    private String cpfCliente;
}
