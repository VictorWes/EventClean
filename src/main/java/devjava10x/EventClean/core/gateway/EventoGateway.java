package devjava10x.EventClean.core.gateway;

import devjava10x.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {


    Evento criarEvento(Evento evento);
    List<Evento> buscarTodosEventos();
    boolean existePorIdentificador(String identificador);
    Optional<Evento> findPorId(Long id);


}
