package group.esig.sistemagestaotarefas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status;
    private String prazo;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Data
    public static class DtoRequest{
        private Long id;
        private String titulo;
        private String descricao;
        private String prioridade;
        private String status;
        private String prazo;
        private Long funcionario_id;

        public static Tarefa convertToEntity(Tarefa.DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Tarefa.class);
        }
    }

    @Data
    public static class DtoResponse{
        private String id;
        private String titulo;
        private String descricao;
        private String prioridade;
        private String status;
        private String prazo;
        private Funcionario funcionario;

        public static Tarefa.DtoResponse convertToDto(Tarefa tarefa, ModelMapper mapper){
            return mapper.map(tarefa, Tarefa.DtoResponse.class);
        }
    }
}