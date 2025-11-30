package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.BoletimDTO;
import br.unipar.devbackend.cadastroaluno2.service.BoletimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*")
public class BoletimController {

    private final BoletimService boletimService;

    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @GetMapping("/{id}/boletim")
    public BoletimDTO gerarBoletim(@PathVariable Long id) {
        return boletimService.gerarBoletim(id);
    }
}

