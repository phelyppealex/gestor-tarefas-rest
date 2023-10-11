package group.esig.sistemagestaotarefas.controller;

import group.esig.sistemagestaotarefas.model.Funcionario;
import group.esig.sistemagestaotarefas.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario/")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return this.service.save(funcionario);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        this.service.delete(id);
    }

    @GetMapping("{id}")
    public Funcionario listarPorId(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    public List<Funcionario> listarTudo(){
        return this.service.findAll();
    }

    @PutMapping
    public Funcionario atualizar(@RequestBody Funcionario funcionario){
        return this.service.update(funcionario);
    }
}
