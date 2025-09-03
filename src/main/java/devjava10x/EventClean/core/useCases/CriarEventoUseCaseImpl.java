package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.gateway.EventoGateway;
import devjava10x.EventClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {

        if (eventoGateway.existePorIdentificador(evento.identificador())){

            throw new DuplicateEventException("O identificador numero: " + evento.identificador() + "ja existe");

        }

        return eventoGateway.criarEvento(evento);
    }
}
