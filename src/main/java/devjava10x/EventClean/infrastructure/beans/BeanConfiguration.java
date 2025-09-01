package devjava10x.EventClean.infrastructure.beans;

import devjava10x.EventClean.core.gateway.EventoGateway;
import devjava10x.EventClean.core.useCases.CriarEventoUseCase;
import devjava10x.EventClean.core.useCases.CriarEventoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }
}
