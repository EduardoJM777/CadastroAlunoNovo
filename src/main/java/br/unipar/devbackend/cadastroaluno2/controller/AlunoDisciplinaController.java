package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.Att1BimDTO;
import br.unipar.devbackend.cadastroaluno2.dto.Att2BimDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.service.AlunoDisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno/disciplina")
@CrossOrigin(origins = "*")
public class AlunoDisciplinaController {

    private final AlunoDisciplinaService adService;

    public AlunoDisciplinaController(AlunoDisciplinaService adService) {
        this.adService = adService;
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

    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/1bim")
    public AlunoDisciplina atualizar1Bim(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody Att1BimDTO dto) {

        return adService.Att1Bim(idAluno, idDisciplina, dto);
    }

    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/2bim")
    public AlunoDisciplina atualizar2Bim(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody Att2BimDTO dto) {

        return adService.Att2Bim(idAluno, idDisciplina, dto);
    }
}
