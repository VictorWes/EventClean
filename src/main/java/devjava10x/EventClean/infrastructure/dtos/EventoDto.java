package devjava10x.EventClean.infrastructure.dtos;

import devjava10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;



public record EventoDto(
        Long id,

        String nome,

        String descricao,

        String identificador,

        String localEvento,

        String organizador,

        Integer capacidade,

        LocalDateTime dataInicio,

        LocalDateTime dataFim,

        TipoEvento tipoEventos) {



}
