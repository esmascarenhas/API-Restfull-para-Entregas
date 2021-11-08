package com.esm.clientelog.domain.service;

import com.esm.clientelog.domain.entity.Entrega;
import com.esm.clientelog.domain.entity.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscarEntregaService buscarEntregaService;
    @Transactional
    public Ocorrencia registrar (Long entregaId, String descricao){
        Entrega entrega = buscarEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrencia(descricao);
    }


}
