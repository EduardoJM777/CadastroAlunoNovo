package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasPresencasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasPresencasService;
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

    @PostMapping("{idAulaDada}")
    public List<AulasDadasPresencas> registrarPresencas(
            @PathVariable Long idAulaDada,
            @RequestBody List<AulasDadasPresencasDTO> presencasDTO) {
        return adpService.registrarPresencas(idAulaDada, presencasDTO);
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
