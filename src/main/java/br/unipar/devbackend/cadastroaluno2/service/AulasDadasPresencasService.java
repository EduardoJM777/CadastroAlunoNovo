package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasPresencasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasPresencasRepository;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AulasDadasPresencasService {


    private final AulasDadasPresencasRepository adpRepository;
    private final AulasDadasRepository aulasDadasRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public AulasDadasPresencasService(AulasDadasPresencasRepository adpRepository, AulasDadasRepository aulasDadasRepository, AlunoRepository alunoRepository){
        this.adpRepository = adpRepository;
        this.aulasDadasRepository = aulasDadasRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<AulasDadasPresencas> registrarPresencas(
            Long idAulaDada,
            List<AulasDadasPresencasDTO> listaDTO
    ){

        var aula = aulasDadasRepository.findById(idAulaDada)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        List<AulasDadasPresencas> presencas = new ArrayList<>();

        for (AulasDadasPresencasDTO dto : listaDTO){

            var aluno = alunoRepository.findById(dto.idAluno())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            var presenca = new AulasDadasPresencas();
            presenca.setAulasDadas(aula);
            presenca.setAluno(aluno);
            presenca.setFalta(dto.falta());

            presencas.add(presenca);
        }

        return adpRepository.saveAll(presencas);
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
