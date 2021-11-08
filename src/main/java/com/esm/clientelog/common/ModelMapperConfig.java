package com.esm.clientelog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig  {

    @Bean // indica que ele instância, inicializa e configura
          // um bean que será gerenciado pelo spring. Portanto,será disponibilizado
          //para injeção em outras classes.
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
