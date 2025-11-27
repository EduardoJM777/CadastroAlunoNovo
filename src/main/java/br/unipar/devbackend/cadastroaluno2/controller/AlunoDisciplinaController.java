package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AtualizarPrimeiroBimestreDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.service.AlunoDisciplinaService;
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
    @PutMapping("/1bim/{id}")
    public AlunoDisciplina atualizar1b(
            @PathVariable Long id,
            @PathVariable Long idDisciplina,
            @RequestBody AtualizarPrimeiroBimestreDTO dto) {

        return adService.atualizar1b(id, idDisciplina, dto);
    }

    @PutMapping("/2bim/{id}")
    public AlunoDisciplina atualizar2b(@PathVariable Long id, @RequestBody AlunoDisciplina alunoDisciplina) {
        return adService.atualizar2b(id, alunoDisciplina);
    }

}
