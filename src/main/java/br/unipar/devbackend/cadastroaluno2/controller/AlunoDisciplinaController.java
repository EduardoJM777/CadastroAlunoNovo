package br.unipar.devbackend.cadastroaluno2.controller;


import br.unipar.devbackend.cadastroaluno2.dto.AlunoDisciplinaDTO;
import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.service.AlunoDisciplinaService;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno/disciplina")
@CrossOrigin(origins = "*")
public class AlunoDisciplinaController {
    private final AlunoDisciplinaService adService;
    public AlunoDisciplinaController(AlunoDisciplinaService adService){
        this.adService = adService;
    }

    @GetMapping("/todos")
    public List<AlunoDisciplinaDTO> getAllAulas(){
        return adService.getAllAulas();
    }

    @PostMapping
    public AlunoDisciplina cadastrar(@RequestBody AlunoDisciplina alunoDisciplina) {
        return adService.salvar(alunoDisciplina);
    }

    @GetMapping
    public List<AlunoDisciplina> listar() {
        return adService.listar();
    }

    @GetMapping("/{id}")
    public AlunoDisciplina buscarPorId(@PathVariable Long id) {
        return adService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoDisciplina atualizar(@PathVariable Long id, @RequestBody AlunoDisciplina alunoDisciplina) {
        return adService.atualizar(id, alunoDisciplina);
    }
}
