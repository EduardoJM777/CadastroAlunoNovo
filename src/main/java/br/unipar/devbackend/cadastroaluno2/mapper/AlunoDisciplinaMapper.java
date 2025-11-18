package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDisciplinaDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;

public class AlunoDisciplinaMapper {

    public AlunoDisciplinaDTO alunoDisciplinaToDTO(AlunoDisciplina alunoDisciplina){
        return new AlunoDisciplinaDTO(
                alunoDisciplina.getAluno(),
                alunoDisciplina.getDisciplina(),
                alunoDisciplina.getNota1Bim(),
                alunoDisciplina.getNota2Bim(),
                alunoDisciplina.getFaltas1Bim(),
                alunoDisciplina.getFaltas2Bim(),
                alunoDisciplina.getMatriculado(),
                alunoDisciplina.getSituacao());
    }


}
