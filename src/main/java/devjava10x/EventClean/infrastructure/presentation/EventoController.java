package devjava10x.EventClean.infrastructure.presentation;


import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.useCases.BuscarTodosEventosUseCase;
import devjava10x.EventClean.core.useCases.CriarEventoUseCase;
import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarTodosEventosUseCase buscarTodosEventosUseCase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, BuscarTodosEventosUseCase buscarTodosEventosUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.buscarTodosEventosUseCase = buscarTodosEventosUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto evento) {
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toEntity(evento));

        return eventoDtoMapper.toDto(novoEvento);
    }

    @GetMapping("todoseventos")
    public List<EventoDto> listaEventos() {
        return buscarTodosEventosUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toList());
    }


}