package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarTodosEventosUseCaseImpl implements BuscarTodosEventosUseCase{

    private final EventoGateway eventoGateway;

    public BuscarTodosEventosUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarTodosEventos();
    }
}
