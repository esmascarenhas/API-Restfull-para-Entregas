package com.esm.clientelog.api.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaModel extends RepresentationModel<OcorrenciaModel> {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;

}
