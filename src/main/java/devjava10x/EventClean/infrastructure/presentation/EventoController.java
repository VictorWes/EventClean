package devjava10x.EventClean.infrastructure.presentation;


import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.useCases.CriarEventoUseCase;
import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto evento){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toEntity(evento));

        return eventoDtoMapper.toDto(novoEvento);
    }


}
