package com.esm.clientelog.api.controller;

import com.esm.clientelog.api.mapper.EntregaMapper;
import com.esm.clientelog.api.model.EntregaModel;
import com.esm.clientelog.api.model.input.EntregaInput;
import com.esm.clientelog.domain.entity.Entrega;
import com.esm.clientelog.domain.repository.EntregaRepository;
import com.esm.clientelog.domain.service.FinalizacaoEntregaService;
import com.esm.clientelog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar (@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.tomodel(entregaSolicitada);
    }
    @PutMapping("/{entregaId}")
       public ResponseEntity<Void> finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
        return ResponseEntity.noContent().build();

    }
//    @GetMapping
//    public List<EntregaModel> listar(){
//        return entregaMapper.toCollectionModel(entregaRepository.findAll());
//    }

    @GetMapping
    public CollectionModel<EntregaModel> listar(){
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel>buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.tomodel(entrega)))
                .orElse(ResponseEntity.notFound().build());

    }


}
