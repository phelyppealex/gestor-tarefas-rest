package group.esig.sistemagestaotarefas.repository;

import group.esig.sistemagestaotarefas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
