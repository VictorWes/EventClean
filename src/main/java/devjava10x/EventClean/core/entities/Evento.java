package devjava10x.EventClean.core.entities;

import devjava10x.EventClean.core.enums.TipoEvento;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record Evento(
            Long id,
            String nome,
            String descricao,
            String identificador,
            String localEvento,
            String organizador,
            Integer capacidade,
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            TipoEvento tipoEventos
) {}

