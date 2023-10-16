package group.esig.sistemagestaotarefas.service;

import group.esig.sistemagestaotarefas.model.Funcionario;
import group.esig.sistemagestaotarefas.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public Funcionario save(Funcionario funcionario){
        funcionario.setId(null);
        return this.repository.save(funcionario);
    }

    public Funcionario findById(Long id){
        Optional<Funcionario> funcionario = this.repository.findById(id);
        if(funcionario.isPresent())
            return funcionario.get();
        throw new EntityNotFoundException();
    }

    public void delete(Long id){
        Funcionario funcionario = findById(id);
        this.repository.delete(funcionario);
    }

    public Funcionario update(Funcionario funcionario){
        delete(funcionario.getId());
        return save(funcionario);
    }

    public List<Funcionario> findAll(){
        return this.repository.findAll();
    }
}