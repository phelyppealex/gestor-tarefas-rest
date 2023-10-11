package group.esig.sistemagestaotarefas.controller;

import group.esig.sistemagestaotarefas.model.Tarefa;
import group.esig.sistemagestaotarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa/")
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa){
        return this.service.save(tarefa);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        this.service.delete(id);
    }

    @GetMapping("{id}")
    public Tarefa listarPorId(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    public List<Tarefa> listarTudo(){
        return this.service.findAll();
    }

    @PutMapping
    public Tarefa atualizar(@RequestBody Tarefa tarefa){
        return this.service.update(tarefa);
    }
}