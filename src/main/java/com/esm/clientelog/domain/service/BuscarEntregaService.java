package com.esm.clientelog.domain.service;

import com.esm.clientelog.domain.entity.Entrega;
import com.esm.clientelog.domain.exception.EntidadeNaoEncontradaException;
import com.esm.clientelog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service //informar que é componente do spring
public class BuscarEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));

    }
}
