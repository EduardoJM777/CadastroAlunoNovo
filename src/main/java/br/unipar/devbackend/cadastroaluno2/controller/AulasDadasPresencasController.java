package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasPresencasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasPresencasService;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auladada")
@CrossOrigin(origins = "*")
public class AulasDadasPresencasController {
    private final AulasDadasPresencasService adpService;
    public AulasDadasPresencasController(AulasDadasPresencasService adpService){
        this.adpService = adpService;
    }

    @GetMapping("/todos")
    public List<AulasDadasPresencasDTO> getAllAulas(){
        return adpService.getAllAulas();
    }

    @PostMapping
    public AulasDadas cadastrar(@RequestBody AulasDadasPresencas aulasDadasPresencas) {
        return adpService.salvar(aulasDadasPresencas);
    }

    @GetMapping
    public List<AulasDadasPresencas> listar() {
        return adpService.listar();
    }

    @GetMapping("/{id}")
    public AulasDadasPresencas buscarPorId(@PathVariable Long id) {
        return adpService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AulasDadasPresencas atualizar(@PathVariable Long id, @RequestBody AulasDadasPresencas aulasDadasPresencas) {
        return adpService.atualizar(id, aulasDadasPresencas);
    }
}
