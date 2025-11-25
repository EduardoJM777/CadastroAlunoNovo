package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.service.AlunoService;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula/disciplina")
@CrossOrigin(origins = "*")
public class AulasDadasController {
    private final AulasDadasService aulasDadasService;
    public AulasDadasController(AulasDadasService aulasDadasService){
        this.aulasDadasService = aulasDadasService;
    }

    @GetMapping("/todos")
    public List<AulasDadasDTO> getAllAulas(){
        return aulasDadasService.getAllAulas();
    }

    @PostMapping
    public AulasDadas cadastrar(@RequestBody AulasDadas aulasDadas) {
        return aulasDadasService.salvar(aulasDadas);
    }

    @GetMapping
    public List<AulasDadas> listar() {
        return aulasDadasService.listar();
    }

    @GetMapping("/{id}")
    public AulasDadas buscarPorId(@PathVariable Long id) {
        return aulasDadasService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AulasDadas atualizar(@PathVariable Long id, @RequestBody AulasDadas aulasDadas) {
        return aulasDadasService.atualizar(id, aulasDadas);
    }
}
