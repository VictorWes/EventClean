package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarTodosEventosUseCase {

    List<Evento> execute();

}
