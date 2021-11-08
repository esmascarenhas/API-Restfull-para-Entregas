package com.esm.clientelog.api.mapper;


import com.esm.clientelog.api.controller.ClienteController;
import com.esm.clientelog.api.controller.EntregaController;
import com.esm.clientelog.api.model.EntregaModel;
import com.esm.clientelog.api.model.input.EntregaInput;
import com.esm.clientelog.domain.entity.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@Component //informar que é um componente do spring
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaModel tomodel(Entrega entrega){
        EntregaModel entregaModel = modelMapper.map(entrega, EntregaModel.class);

        entregaModel.add(linkTo(methodOn(EntregaController.class).buscar(entrega.getId()))
                .withSelfRel());
        entregaModel.add(linkTo(methodOn(EntregaController.class).listar())
                .withRel("lista_de-Entregas"));

        entregaModel.getCliente().add(linkTo(methodOn(ClienteController.class).
                buscar(entrega.getCliente().getId())).withSelfRel());

        if(entrega.podeSerFinalizado()){
            entregaModel.add(linkTo(methodOn(EntregaController.class)
                    .finalizar(entrega.getId())).withRel("Finalizar Entrega"));
        }

        return entregaModel;
    }
 /*   public List<EntregaModel>toCollectionModel(List<Entrega>entregas){
        return entregas.stream()
                .map(this::tomodel)
                .collect(Collectors.toList());

    }*/
 public CollectionModel<EntregaModel>toCollectionModel(List<Entrega>entregas){
     var entregaModel = CollectionModel.of(entregas.stream()
             .map(this::tomodel)
             .collect(Collectors.toList()));

        entregaModel.add(linkTo(methodOn(EntregaController.class)
                .listar()).withSelfRel());
     return entregaModel;

 }
    public Entrega toEntity(EntregaInput entregaInput){

        return modelMapper.map(entregaInput,Entrega.class);
    }



}
