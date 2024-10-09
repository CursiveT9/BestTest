package com.example.besttest.config;

import com.example.besttest.dtos.TestingDTO;
import com.example.besttest.models.entities.Testing;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Testing, TestingDTO> typeTestingDTO = modelMapper.createTypeMap(Testing.class, TestingDTO.class);
        typeTestingDTO.addMapping(src -> src.getUser().getId(), TestingDTO::setCreatorId);

        return modelMapper;
    }

}
