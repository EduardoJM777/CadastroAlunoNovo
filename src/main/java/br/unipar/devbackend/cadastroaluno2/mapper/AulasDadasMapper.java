package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AulasDadasDTO;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;

public class AulasDadasMapper {

    private DisciplinaRepository disciplinaRepository;

    public AulasDadas toEntity(AulasDadasDTO dto){
        if (dto == null) return null;

        AulasDadas entity = new AulasDadas();
        entity.setId(dto.id());

        entity.setDisciplina(
                disciplinaRepository.findById(dto.idDisciplina())
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"))
        );

        entity.setData(dto.data());
        entity.setObservacoes(dto.observacoes());

        return entity;
    }

    public AulasDadasDTO toDTO(AulasDadas entity){
        if (entity == null) return null;

        return new AulasDadasDTO(
                entity.getId(),
                entity.getDisciplina().getId(),
                entity.getData(),
                entity.getObservacoes()
        );

    }

}
