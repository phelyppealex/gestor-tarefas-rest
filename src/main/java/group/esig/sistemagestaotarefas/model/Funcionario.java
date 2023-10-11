package group.esig.sistemagestaotarefas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Funcionario {
    @Id
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;
}