package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
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

    @PostMapping("/{idDisciplina}")
    public AulasDadas cadastrar(@PathVariable Long idDisciplina,
                                @RequestBody AulasDadas aulasDadas) {
        return aulasDadasService.salvar(idDisciplina, aulasDadas);
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
