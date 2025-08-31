package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;

public interface BuscarPorIdEventoUseCase {

    Evento execute(Evento evento);
}
