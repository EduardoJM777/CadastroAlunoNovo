package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasPresencasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AulasDadasPresencasService {

    @Autowired
    private final AulasDadasPresencasRepository adpRepository;

    public AulasDadasPresencasService(AulasDadasPresencasRepository adpRepository){
        this.adpRepository = adpRepository;
    }

    public AulasDadasPresencas salvar(AulasDadasPresencas adp){
        return adpRepository.save(adp);
    }

    public List<AulasDadasPresencas> listar(){
        return adpRepository.findAll();
    }

    public AulasDadasPresencas atualizar(Long id, AulasDadasPresencas adpAtualizado){
        return adpRepository.findById(id).map(adp -> {
            adp.setFalta(adpAtualizado.getFalta());
            adp.setAulasDadas(adpAtualizado.getAulasDadas());
            adp.setAluno(adpAtualizado.getAluno());
            return adpRepository.save(adp);
        }).orElseThrow(() -> new RuntimeException("Não encontrado(a)"));
    }

    public AulasDadasPresencas buscarPorId(Long id){
        return adpRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado(a)"));
    }


}
