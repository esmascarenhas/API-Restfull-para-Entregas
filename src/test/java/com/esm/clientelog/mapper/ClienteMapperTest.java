package com.esm.clientelog.mapper;

import com.esm.clientelog.api.mapper.ClienteMapper;
import com.esm.clientelog.api.model.ClienteModel;
import com.esm.clientelog.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteMapperTest {

        @Autowired
        private ClienteMapper clienteMapper;

    void TestGivenClienteModelThenReturnClienteEntity(){

        ClienteModel clienteModel = ClienteUtils.createFakeModel();
    }
}
