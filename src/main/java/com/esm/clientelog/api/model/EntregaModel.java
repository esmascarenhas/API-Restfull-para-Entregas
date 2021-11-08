package com.esm.clientelog.api.model;

import com.esm.clientelog.domain.entity.StatusEntrega;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Relation(collectionRelation = "Relatório de Entregas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EntregaModel extends RepresentationModel<EntregaModel> {

    private Long id;
    private ClienteResumoModel cliente;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
