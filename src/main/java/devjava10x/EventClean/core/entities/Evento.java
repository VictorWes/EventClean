package devjava10x.EventClean.core.entities;

import devjava10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
            Long id,
            String nome,
            String descricao,
            String identificador,
            String local,
            String organizador,
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            TipoEvento tipoEventos
) {}

