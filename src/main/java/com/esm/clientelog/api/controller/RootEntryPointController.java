package com.esm.clientelog.api.controller;

import com.esm.clientelog.api.model.RootEntryPointModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RootEntryPointController {

        @GetMapping
    public RootEntryPointModel root(){
            var model = new RootEntryPointModel();
            model.add(linkTo(methodOn(EntregaController.class)
                    .listar()).withRel("Relatório de Entregas"));
        return model;
    }
}
