package group.esig.sistemagestaotarefas.repository;

import group.esig.sistemagestaotarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}