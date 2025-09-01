package devjava10x.EventClean.infrastructure.mapper;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.infrastructure.persitence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento){
        return new EventoEntity(
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


    public Evento toDomain(EventoEntity eventoEntity){

        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getIdentificador(),
                eventoEntity.getLocalEvento(),
                eventoEntity.getOrganizador(),
                eventoEntity.getCapacidade(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getTipoEventos());



    }


}
