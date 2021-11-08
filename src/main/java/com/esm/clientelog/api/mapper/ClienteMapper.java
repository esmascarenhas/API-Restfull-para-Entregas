package com.esm.clientelog.api.mapper;


import com.esm.clientelog.api.controller.ClienteController;
import com.esm.clientelog.api.model.ClienteModel;
import com.esm.clientelog.api.model.input.ClienteInput;
import com.esm.clientelog.domain.entity.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@Component
public class ClienteMapper {

    private ModelMapper modelMapper;

    public ClienteModel toModel(Cliente cliente){
        ClienteModel clienteModel = modelMapper.map(cliente,ClienteModel.class);

        //clienteModel.add(Link.of("http://localhost:8080/api/v1/clientes/1"));
       /* clienteModel.add(linkTo(ClienteController.class).slash(cliente.getId()).withSelfRel());*/
        clienteModel.add(linkTo(methodOn(ClienteController.class).buscar(cliente.getId()))
                .withSelfRel());
        clienteModel.add(linkTo(methodOn(ClienteController.class).listarCliente())
                .withRel(IanaLinkRelations.COLLECTION));
        clienteModel.add(linkTo(methodOn(ClienteController.class).listarCliente())
                .withRel("lista-cliente"));
        return clienteModel;
    }
/*    public List<ClienteModel>toCollectionModel(List<Cliente>clientes){
        return clientes.stream().map(this::toModel)
                .collect(Collectors.toList());
    }*/
    public CollectionModel<ClienteModel> toCollectionModel(List<Cliente>clientes){
        var clientemodel = CollectionModel.of(clientes.stream()
                .map(this::toModel)
                .collect(Collectors.toList()));
        return clientemodel;
    }
    public Cliente toEntity(ClienteInput clienteInput){
        return modelMapper.map(clienteInput,Cliente.class);
    }
}
