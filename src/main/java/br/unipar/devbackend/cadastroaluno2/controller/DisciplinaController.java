package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
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
        return disciplinaService.atualizar(id, disciplina);
    }
}
