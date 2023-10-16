package group.esig.sistemagestaotarefas.service;

import group.esig.sistemagestaotarefas.model.Tarefa;
import group.esig.sistemagestaotarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final FuncionarioService funcionarioService;
    private ModelMapper mapper;

    public TarefaService(TarefaRepository repository, FuncionarioService funcionarioService, ModelMapper mapper){
        this.repository = repository;
        this.funcionarioService = funcionarioService;
        this.mapper = mapper;
    }

    public void save(Tarefa.DtoRequest tarefaDto){
        var tarefa = Tarefa.DtoRequest.convertToEntity(tarefaDto, this.mapper);

        tarefa.setFuncionario(
            this.funcionarioService.findById(
                tarefaDto.getFuncionario_id()
            )
        );

        tarefa.setId(null);

        this.repository.save(tarefa);
    }

    public void save(Tarefa tarefa){
        this.repository.save(tarefa);
    }

    public Tarefa findById(Long id){
        Optional<Tarefa> tarefa = this.repository.findById(id);
        if(tarefa.isPresent())
            return tarefa.get();
        throw new EntityNotFoundException();
    }

    public void delete(Long id){
        var tarefa = findById(id);
        this.repository.delete(tarefa);
    }

    public void update(Tarefa tarefa){
        delete(tarefa.getId());
        save(tarefa);
    }

    public List<Tarefa> findAll(){
        return this.repository.findAll();
    }
}
