package org.rail.irctc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IrctcConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
