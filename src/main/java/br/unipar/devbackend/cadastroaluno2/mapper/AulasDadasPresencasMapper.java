package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasPresencasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AulasDadasPresencasMapper {

    @Autowired
    private AulasDadasRepository aulasDadasRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public AulasDadasPresencas toEntity(AulasDadasPresencasDTO dto){
        if (dto == null) return null;

        AulasDadasPresencas entity = new AulasDadasPresencas();
        entity.setFalta(dto.falta());

        entity.setAluno(
                alunoRepository.findById(dto.idAluno())
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"))
        );

        return entity;

    }

    public AulasDadasPresencasDTO toDTO(AulasDadasPresencas entity){
        if (entity == null) return null;

        return new AulasDadasPresencasDTO(
                entity.getAluno().getId(),
                entity.getFalta()
        );
    }

}
