package devjava10x.EventClean.infrastructure.presentation;


import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.useCases.BuscarPorIdEventoUseCase;
import devjava10x.EventClean.core.useCases.BuscarTodosEventosUseCase;
import devjava10x.EventClean.core.useCases.CriarEventoUseCase;
import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.exception.IdNotFoundException;
import devjava10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Salva evento", description = "Metodo resposnavel por salvar um novo evento no banco de dados")
    @ApiResponse(responseCode = "201", description = "Filme Salvo com sucesso",
    content = @Content(schema = @Schema(implementation = EventoDto.class)))
    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto evento) {
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toEntity(evento));

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastro com sucesso no nosso banco de dados");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(novoEvento));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca eventos", description = "Metodo responsavel por buscar todos os eventos no banco de dados")
    @ApiResponse(responseCode = "200", description = "Eventos listados com sucesso",
    content = @Content(schema = @Schema(implementation = EventoDto.class)))
    @GetMapping("todoseventos")
    public List<EventoDto> listaEventos() {
        return buscarTodosEventosUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca evento por id", description = "Metodo responsavel por localizar somente um evento por ID")
    @ApiResponse(responseCode = "200", description = "Evento localizado com sucesso",
    content = @Content(schema = @Schema(implementation = EventoDto.class)))
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findPorId(@PathVariable Long id) {

        Evento findIdDto = buscarPorIdEventoUseCase.execute(id);

        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento localizado com sucesso no banco de dados");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(findIdDto));

        return ResponseEntity.ok(response);
    }
}