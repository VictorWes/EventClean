package devjava10x.EventClean.infrastructure.presentation;


import devjava10x.EventClean.infrastructure.dtos.EventoDto;
import devjava10x.EventClean.infrastructure.persitence.EventoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    @PostMapping("criarevento")
    public ResponseEntity<EventoDto> criarEvento(@RequestBody EventoDto evento){




        return ResponseEntity.ok().build();
    }


}
