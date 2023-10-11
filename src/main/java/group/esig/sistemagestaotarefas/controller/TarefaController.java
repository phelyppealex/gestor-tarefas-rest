package group.esig.sistemagestaotarefas.controller;

import group.esig.sistemagestaotarefas.model.Tarefa;
import group.esig.sistemagestaotarefas.model.Tarefa.DtoResponse;
import group.esig.sistemagestaotarefas.service.TarefaService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarefa/")
public class TarefaController {
    private final TarefaService service;
    private final ModelMapper mapper;

    public TarefaController(TarefaService service, ModelMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa.DtoRequest tarefaDto){
        Tarefa tarefa = Tarefa.DtoRequest.convertToEntity(tarefaDto, this.mapper);
        return this.service.save(tarefa);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        this.service.delete(id);
    }

    @GetMapping("{id}")
    public Tarefa.DtoResponse listarPorId(@PathVariable Long id){
        return Tarefa.DtoResponse.convertToDto(this.service.findById(id), this.mapper);
    }

    @GetMapping
    public List<Tarefa.DtoResponse> listarTudo(){
        List<Tarefa.DtoResponse> tarefas = new ArrayList<Tarefa.DtoResponse>();
        
        for(Tarefa t : this.service.findAll()){
            tarefas.add(
                Tarefa.DtoResponse.convertToDto(t, this.mapper)
            );
        }

        return tarefas;
    }

    @PutMapping
    public Tarefa atualizar(@RequestBody Tarefa.DtoRequest tarefaDto){
        Tarefa tarefa = Tarefa.DtoRequest.convertToEntity(tarefaDto, this.mapper);
        return this.service.update(tarefa);
    }
}