package com.esm.clientelog.api.controller;

import com.esm.clientelog.api.mapper.OcorrenciaMapper;
import com.esm.clientelog.api.model.OcorrenciaModel;
import com.esm.clientelog.api.model.input.OcorrenciaInput;
import com.esm.clientelog.domain.entity.Entrega;
import com.esm.clientelog.domain.entity.Ocorrencia;
import com.esm.clientelog.domain.service.BuscarEntregaService;
import com.esm.clientelog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/entregas/{entregaId}/ocorrencia")
public class OcorrenciaController {

    private BuscarEntregaService buscarEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
                ocorrenciaInput.getDescricao());
        return ocorrenciaMapper.tomodel(ocorrenciaRegistrada);
    }
    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscarEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }




}
