    package com.esm.clientelog.api.mapper;

import com.esm.clientelog.api.controller.OcorrenciaController;
import com.esm.clientelog.api.model.OcorrenciaModel;
import com.esm.clientelog.domain.entity.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaModel tomodel(Ocorrencia ocorrencia){

        OcorrenciaModel ocorrenciaModel = modelMapper.map(ocorrencia,OcorrenciaModel.class);

        //ocorrenciaModel.add(linkTo(methodOn(OcorrenciaController.class)).withRel("ocorrência"));

        return ocorrenciaModel;

    }
    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia>ocorrencias){
        return ocorrencias.stream().map(this::tomodel)
                .collect(Collectors.toList());

    }
}
