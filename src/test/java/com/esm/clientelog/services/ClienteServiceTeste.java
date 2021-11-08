package com.esm.clientelog.services;

import com.esm.clientelog.api.mapper.ClienteMapper;
import com.esm.clientelog.api.model.ClienteModel;
import com.esm.clientelog.domain.entity.Cliente;
import com.esm.clientelog.domain.repository.ClienteRepository;
import com.esm.clientelog.domain.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static com.esm.clientelog.utils.ClienteUtils.createFakeEntity;
import static com.esm.clientelog.utils.ClienteUtils.createFakeModel;
import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTeste {

    @Mock
    private ClienteMapper clienteMapper;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ClienteService clienteService;

  /*  @Test
    void testGivenClienteModelThenReturnSuccessSavedMessage() {
        ClienteModel clienteModel = createFakeModel();
        Cliente expectedSavedCliente = createFakeEntity();

        when(clienteMapper.toModel(clienteModel)).thenReturn(expectedSavedCliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(expectedSavedCliente);

       ResponseEntity<ClienteModel>expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        ResponseEntity<ClienteModel> successMessage = clienteService.salvar(cliente);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }*/

}
