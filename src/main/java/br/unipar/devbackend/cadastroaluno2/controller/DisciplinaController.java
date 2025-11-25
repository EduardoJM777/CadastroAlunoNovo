package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.dto.DisciplinaDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import br.unipar.devbackend.cadastroaluno2.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disicplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/todos")
    public List<DisciplinaDTO> getAllDisciplinas(){
        return disciplinaService.getAllDisciplinas();
    }

    @PostMapping
    public DisciplinaService cadastrar(@RequestBody DisciplinaService disciplinaService) {
        return disciplinaService.salvar(disciplinaService);
    }

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaService.listar();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable Long id) {
        return disciplinaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        return disciplina.atualizar(id, disciplina);
    }
}
