package devjava10x.EventClean.infrastructure.presentation;


import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.useCases.BuscarPorIdEventoUseCase;
import devjava10x.EventClean.core.useCases.BuscarTodosEventosUseCase;
import devjava10x.EventClean.core.useCases.CriarEventoUseCase;
import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.exception.IdNotFoundException;
import devjava10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarTodosEventosUseCase buscarTodosEventosUseCase;
    private final BuscarPorIdEventoUseCase buscarPorIdEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;


    public EventoController(CriarEventoUseCase criarEventoUseCase, BuscarTodosEventosUseCase buscarTodosEventosUseCase, BuscarPorIdEventoUseCase buscarPorIdEventoUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.buscarTodosEventosUseCase = buscarTodosEventosUseCase;
        this.buscarPorIdEventoUseCase = buscarPorIdEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto evento) {
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toEntity(evento));

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastro com sucesso no nosso banco de dados");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(novoEvento));

        return ResponseEntity.ok(response);
    }

    @GetMapping("todoseventos")
    public List<EventoDto> listaEventos() {
        return buscarTodosEventosUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Evento findPorId(@PathVariable Long id) {
        Optional<Evento> optionalEvento = buscarPorIdEventoUseCase.execute(id);
        return optionalEvento.orElseThrow(() -> new IdNotFoundException("O ID " + id + " não foi localizado"));
    }
}