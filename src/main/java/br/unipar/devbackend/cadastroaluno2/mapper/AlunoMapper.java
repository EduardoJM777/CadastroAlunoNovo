package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;

public class AlunoMapper {

    //mapeador

    public static AlunoDTO alunoToDTO(Aluno aluno){
        return new AlunoDTO(aluno.getRa(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getCurso().getNome());
    }

}
