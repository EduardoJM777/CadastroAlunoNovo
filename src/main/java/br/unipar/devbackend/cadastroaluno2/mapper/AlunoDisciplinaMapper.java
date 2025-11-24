package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDisciplinaDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoDisciplinaMapper {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public AlunoDisciplina toEntity(AlunoDisciplinaDTO dto){
        if (dto == null) return null;

        AlunoDisciplina entity = new AlunoDisciplina();
        entity.setId(dto.id());

        entity.setAluno(
                alunoRepository.findById(dto.alunoId())
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"))
        );

        entity.setDisciplina(
                disciplinaRepository.findById(dto.disciplinaId())
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"))
        );

        entity.setNota1Bim(dto.nota1bim());
        entity.setNota2Bim(dto.nota2bim());
        entity.setFaltas1Bim(dto.falta1bim());
        entity.setFaltas2Bim(dto.falta2bim());
        entity.setMatriculado(dto.matriculado());
        entity.setSituacao(dto.situacao());

        return entity;
    }

    public AlunoDisciplinaDTO toDTO(AlunoDisciplina entity){
        if (entity == null) return null;

        return new AlunoDisciplinaDTO(
            entity.getId(),
            entity.getAluno().getId(),
            entity.getDisciplina().getId(),
            entity.getNota1Bim(),
            entity.getNota2Bim(),
            entity.getFaltas1Bim(),
                entity.getFaltas2Bim(),
                entity.getMatriculado(),
                entity.getSituacao()
        );
    }
}
