package devjava10x.EventClean.core.gateway;

import devjava10x.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {


    Evento criarEvento(Evento evento);
    List<Evento> buscarTodosEventos();
    boolean existePorIdentificador(String identificador);


}
