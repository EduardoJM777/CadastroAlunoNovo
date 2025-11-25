package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.dto.LancamentoDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Lancamento;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import br.unipar.devbackend.cadastroaluno2.service.LancamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno/{idAluno}")
@CrossOrigin(origins = "*")
public class LancamentoController {
    private final LancamentoService lancamentoService;
    public LancamentoController(LancamentoService lancamentoService){
        this.lancamentoService = lancamentoService;
    }

    @GetMapping("/todos")
    public List<LancamentoDTO> getAllLancamentos(){
        return lancamentoService.getAllLancamento();
    }

    @PostMapping
    public Lancamento cadastrar(@RequestBody Lancamento lancamento) {
        return lancamentoService.salvar(lancamento);
    }

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentoService.listar();
    }

    @GetMapping("/{id}")
    public Lancamento buscarPorId(@PathVariable Long id) {
        return lancamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Lancamento atualizar(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        return lancamentoService.atualizar(id, lancamento);
    }
}
