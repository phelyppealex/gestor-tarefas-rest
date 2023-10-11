package group.esig.sistemagestaotarefas.service;

import group.esig.sistemagestaotarefas.model.Tarefa;
import group.esig.sistemagestaotarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }

    public Tarefa save(Tarefa tarefa){
        return this.repository.save(tarefa);
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

    public Tarefa update(Tarefa tarefa){
        delete(tarefa.getId());
        return save(tarefa);
    }

    public List<Tarefa> findAll(){
        return this.repository.findAll();
    }
}
