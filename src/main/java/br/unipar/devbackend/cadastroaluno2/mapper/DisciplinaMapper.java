package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.DisciplinaDTO;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaMapper {

    @Autowired
    private ProfessorRepository professorRepository;

    public Disciplina toEntity (DisciplinaDTO dto){
        if (dto == null) return null;

        Disciplina entity = new Disciplina();
        entity.setId(dto.id());
        entity.setCodigo(dto.codigo());
        entity.setDescricao(dto.descricao());
        entity.setEmenta(dto.ementa());

        entity.setProfessor(
                professorRepository.findById(dto.idProfessor())
                        .orElseThrow(() -> new RuntimeException("Professor não encontrado"))
        );

        return entity;
    }

    public DisciplinaDTO toDTO (Disciplina entity){
        if (entity == null) return null;

        return new DisciplinaDTO(
                entity.getId(),
                entity.getCodigo(),
                entity.getDescricao(),
                entity.getEmenta(),
                entity.getProfessor().getId()
        );
    }

}