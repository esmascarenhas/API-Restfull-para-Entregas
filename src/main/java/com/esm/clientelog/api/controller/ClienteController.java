package com.esm.clientelog.api.controller;

import com.esm.clientelog.api.mapper.ClienteMapper;
import com.esm.clientelog.api.model.ClienteModel;
import com.esm.clientelog.api.model.input.ClienteInput;
import com.esm.clientelog.domain.entity.Cliente;
import com.esm.clientelog.domain.exception.ClienteNaoEncontrado;
import com.esm.clientelog.domain.repository.ClienteRepository;
import com.esm.clientelog.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

   private ClienteRepository clienteRepository;
   private ClienteService clienteService;
   private ClienteMapper clienteMapper;

    @GetMapping
    public CollectionModel<ClienteModel> listarCliente(){

        return clienteMapper.toCollectionModel(clienteRepository.findAll());
    }


    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteModel> buscar(@PathVariable Long clienteId) {

        return clienteRepository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(clienteMapper.toModel(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel adicionar(@Valid @RequestBody ClienteInput clienteInput) {
        Cliente novoCliente = clienteMapper.toEntity(clienteInput);
        Cliente clienteCadastrado =  clienteService.salvar(novoCliente);
        return clienteMapper.toModel(clienteCadastrado);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                                             @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        clienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }


}
