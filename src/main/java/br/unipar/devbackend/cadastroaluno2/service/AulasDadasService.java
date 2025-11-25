package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulasDadasService {

    @Autowired
    private final AulasDadasRepository adRepository;

    public AulasDadasService(AulasDadasRepository adRepository){
        this.adRepository = adRepository;
    }

    public AulasDadas salvar(AulasDadas aulasDadas){
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
