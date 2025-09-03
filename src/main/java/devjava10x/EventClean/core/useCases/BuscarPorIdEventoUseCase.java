package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;

import java.util.Optional;

public interface BuscarPorIdEventoUseCase {

    Optional<Evento> execute(Long id);
}
