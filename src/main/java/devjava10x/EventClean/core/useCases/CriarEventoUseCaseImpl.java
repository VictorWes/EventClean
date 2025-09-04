package devjava10x.EventClean.core.useCases;

import devjava10x.EventClean.core.entities.Evento;
import devjava10x.EventClean.core.gateway.EventoGateway;
import devjava10x.EventClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;
    private final GerarIdentificadorUseCase gerarIdentificadorUseCase;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway, GerarIdentificadorUseCase gerarIdentificadorUseCase) {
        this.eventoGateway = eventoGateway;
        this.gerarIdentificadorUseCase = gerarIdentificadorUseCase;
    }

    @Override
    public Evento execute(Evento evento) {

        String identificador = evento.identificador();

        if (identificador == null || identificador.isBlank()){
            identificador = gerarIdentificadorUseCase.executeGerador();
        }

        if (eventoGateway.existePorIdentificador(evento.identificador())){

            throw new DuplicateEventException("O identificador numero: " + evento.identificador() + "ja existe");

        }
        Evento eventoComId = new Evento(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                identificador,
                evento.localEvento(),
                evento.organizador(),
                evento.capacidade(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.tipoEventos()
        );

        return eventoGateway.criarEvento(eventoComId);
    }
}
