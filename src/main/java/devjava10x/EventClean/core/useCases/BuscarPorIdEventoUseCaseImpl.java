package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.gateway.EventoGateway;

import java.util.Optional;

public class BuscarPorIdEventoUseCaseImpl implements BuscarPorIdEventoUseCase {

    private final EventoGateway eventoGateway;

    public BuscarPorIdEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Optional<Evento> execute(Long id) {
        return eventoGateway.findPorId(id);
    }

}
