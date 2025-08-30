package devjava10x.EventClean.infrastructure.mapper;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.persitence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {


    public EventoDto toDto(Evento evento){

        return new EventoDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.localEvento(),
                evento.organizador(),
                evento.capacidade(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.tipoEventos());

    }

   public Evento toEntity(Evento eventoDto){

       return new Evento(
               eventoDto.id(),
               eventoDto.nome(),
               eventoDto.descricao(),
               eventoDto.identificador(),
               eventoDto.localEvento(),
               eventoDto.organizador(),
               eventoDto.capacidade(),
               eventoDto.dataInicio(),
               eventoDto.dataFim(),
               eventoDto.tipoEventos());

   }



}
