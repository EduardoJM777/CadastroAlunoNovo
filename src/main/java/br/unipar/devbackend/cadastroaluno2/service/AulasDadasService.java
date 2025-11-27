package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasRepository;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulasDadasService {

    private final AulasDadasRepository adRepository;

    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    public AulasDadasService(AulasDadasRepository adRepository, DisciplinaRepository disciplinaRepository) {
        this.adRepository = adRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public AulasDadas salvar(Long idDisciplina, AulasDadas aulasDadas){

        var disciplina = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        aulasDadas.setDisciplina(disciplina);
        return adRepository.save(aulasDadas);
    }

    public List<AulasDadas> listar(){
        return adRepository.findAll();
    }

    public AulasDadas atualizar(Long id, AulasDadas adAtualizado){
        return adRepository.findById(id).map(aulasDadas -> {
            aulasDadas.setData(adAtualizado.getData());
            aulasDadas.setObservacoes(adAtualizado.getObservacoes());
            aulasDadas.setDisciplina(adAtualizado.getDisciplina());
            return adRepository.save(aulasDadas);
        }).orElseThrow(() -> new RuntimeException("Não encontrado(a)"));
    }

    public AulasDadas buscarPorId(Long id){
        return adRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado(a)"));
    }


}
