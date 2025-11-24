package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;

public class AlunoMapper {

    private DisciplinaRepository disciplinaRepository;

    public Aluno toEntity (AlunoDTO dto){
        if (dto == null) return null;

        Aluno entity = new Aluno();
        entity.setId(dto.id());
        entity.setCpf(dto.cpf());
        entity.setRa(dto.ra());
        entity.setNome(dto.nome());
        entity.setAnoIngresso(dto.anoIngresso());
        entity.setPeriodoAtual(dto.periodoAtual());

        entity.setDisciplina(
                disciplinaRepository.findById(dto.idDisciplina())
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"))
        );

        return entity;
    }

    public AlunoDTO toDTO(Aluno entity){
        if (entity == null) return null;

        return new AlunoDTO(
            entity.getId(),
            entity.getCpf(),
            entity.getRa(),
            entity.getNome(),
            entity.getAnoIngresso(),
            entity.getPeriodoAtual(),
            entity.getDisciplina().getId()
        );

        }

    }
