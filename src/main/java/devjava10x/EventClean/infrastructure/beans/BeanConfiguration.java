package devjava10x.EventClean.infrastructure.beans;

import devjava10x.EventClean.core.gateway.EventoGateway;
import devjava10x.EventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarTodosEventosUseCase buscarTodosEventos(EventoGateway eventoGateway){
        return new BuscarTodosEventosUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarPorIdEventoUseCase buscarPorIdEventoUseCase(EventoGateway eventoGateway){
        return new BuscarPorIdEventoUseCaseImpl(eventoGateway);
    }
}
