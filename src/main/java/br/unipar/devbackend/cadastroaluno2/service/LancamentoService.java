package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Lancamento;
import br.unipar.devbackend.cadastroaluno2.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private final LancamentoRepository lancamentoRepository;
    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listarTodos(){
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarPorId(Long id){
        return lancamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
    }

    public Lancamento atualizar(Lancamento lc, Long id){
        return lancamentoRepository.findById(id)
                .map(lancamento -> {
                    lancamento.setAluno(lc.getAluno());
                    lancamento.setDisciplina(lc.getDisciplina());
                    return lancamentoRepository.save(lancamento);
                }).orElseThrow(() -> new RuntimeException("Não encontrado"));
    }
}
