package group.esig.sistemagestaotarefas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Tarefa {
    @Id
    private Long id;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade;
    private String status;
    private Date prazo;
}