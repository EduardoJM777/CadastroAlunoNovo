package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.ProfessorDTO;
import br.unipar.devbackend.cadastroaluno2.model.Professor;

public class ProfessorMapper {

    public Professor toEntity (ProfessorDTO dto){
        if (dto == null) return null;

        Professor entity = new Professor();
        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setMatricula(dto.matricula());
        entity.setCpf(dto.cpf());

        return entity;
    }

    public ProfessorDTO toDTO (Professor entity){
        if (entity == null) return null;

        return new ProfessorDTO(
                entity.getId(),
                entity.getNome(),
                entity.getMatricula(),
                entity.getCpf()
        );
    }

}
