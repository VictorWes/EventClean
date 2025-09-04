package devjava10x.EventClean.infrastructure.gateway;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.gateway.EventoGateway;
import devjava10x.EventClean.core.useCases.GerarIdentificadorUseCase;
import devjava10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import devjava10x.EventClean.infrastructure.persitence.EventoEntity;
import devjava10x.EventClean.infrastructure.persitence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway, GerarIdentificadorUseCase {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper eventoEntityMapper;


    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = eventoEntityMapper.toEntity(evento);
        EventoEntity novoEvento = eventoRepository.save(entity);
        return eventoEntityMapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> buscarTodosEventos() {
        return eventoRepository.findAll().stream()
                .map(eventoEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll()
                .stream()
                .anyMatch(evento -> evento.getIdentificador().equals(identificador));
    }

    @Override
    public Optional<Evento> findPorId(Long id) {
        return eventoRepository.findById(id).map(eventoEntityMapper::toDomain);
    }

    @Override
    public String executeGerador() {
        String letras = RandomStringUtils.randomAlphabetic(3).toUpperCase();
        String numeros = RandomStringUtils.randomNumeric(3);
        return letras + numeros;
    }

}
