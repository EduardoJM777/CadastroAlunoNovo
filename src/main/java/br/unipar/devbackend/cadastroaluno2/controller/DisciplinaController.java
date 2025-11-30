package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
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

    @GetMapping("/{codigo}")
    public Disciplina buscarPorCodigo(@PathVariable String codigo){
        Disciplina disciplina = disciplinaService.buscarPorCodigo(codigo);
        return disciplina;
    }

    @GetMapping("/professor/{idProfessor}")
    public List<Disciplina> listarPorProfessor(@PathVariable Long idProfessor){
        List<Disciplina> disciplinas = disciplinaService.listarPorProfessor(idProfessor);
        return disciplinas;
    }

    @GetMapping("/matriculados/{idDisciplina}")
    public List<Aluno> listarMatriculados(@PathVariable Long idDisciplina){
        List<Aluno> alunos = disciplinaService.listarAlunosMatriculados(idDisciplina);
        return alunos;
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        return disciplinaService.atualizar(id, disciplina);
    }
}
