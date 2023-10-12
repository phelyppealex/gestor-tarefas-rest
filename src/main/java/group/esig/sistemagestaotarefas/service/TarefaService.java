package group.esig.sistemagestaotarefas.service;

import group.esig.sistemagestaotarefas.model.Funcionario;
import group.esig.sistemagestaotarefas.model.Tarefa;
import group.esig.sistemagestaotarefas.repository.FuncionarioRepository;
import group.esig.sistemagestaotarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private ModelMapper mapper;

    public TarefaService(TarefaRepository repository, FuncionarioRepository funcionarioRepository, ModelMapper mapper){
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.mapper = mapper;
    }

    public void save(Tarefa.DtoRequest tarefaDto){
        System.out.println("Passou save service");

        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(tarefaDto.getFuncionario_id());
        if(funcionario.isPresent()) {
            Tarefa tarefa = Tarefa.DtoRequest.convertToEntity(tarefaDto, this.mapper);
            tarefa.setFuncionario(funcionario.get());
            save(tarefa);
        }else{
            throw new EntityNotFoundException();
        }
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
        Tarefa tarefa = findById(id);
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
