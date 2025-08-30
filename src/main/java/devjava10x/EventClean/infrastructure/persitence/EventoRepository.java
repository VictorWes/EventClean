package devjava10x.EventClean.infrastructure.persitence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
