package com.esm.clientelog.domain.service;

import com.esm.clientelog.domain.entity.Entrega;
import com.esm.clientelog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscarEntregaService buscarEntregaService;

    public ResponseEntity<Void> finalizar (Long entregaId){
        Entrega entrega = buscarEntregaService.buscar(entregaId);

        entrega.finalizar();
        entregaRepository.save(entrega);
        return ResponseEntity.noContent().build();
    }

}
