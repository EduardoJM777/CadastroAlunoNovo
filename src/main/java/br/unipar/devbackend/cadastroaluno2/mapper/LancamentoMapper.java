package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.LancamentoDTO;
import br.unipar.devbackend.cadastroaluno2.model.Lancamento;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LancamentoMapper {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Lancamento toEntity (LancamentoDTO dto){
        if (dto == null) return null;

        Lancamento entity = new Lancamento();
        entity.setId(dto.id());

        entity.setAluno(
                alunoRepository.findById(dto.idAluno())
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"))
        );

        entity.setDisciplina(
                disciplinaRepository.findById(dto.idDisciplina())
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"))
        );

        return entity;
    }

    public LancamentoDTO toDTO (Lancamento entity){
        if (entity == null) return null;

        return new LancamentoDTO(
                entity.getId(),
                entity.getAluno().getId(),
                entity.getDisciplina().getId()
        );
    }

}
