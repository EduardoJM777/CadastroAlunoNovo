package br.unipar.devbackend.cadastroaluno2.mapper;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;

public class AlunoMapper {

    public AlunoDTO alunoToDTO(Aluno aluno){
        return new AlunoDTO(
                aluno.getRa(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getCurso() != null ? aluno.getCurso().getDescricao() : null);
    }

    public Aluno DTOtoAluno(AlunoDTO alunoDTO){
        if (alunoDTO == null) return null;

        Disciplina disciplina = new Disciplina();
        disciplina.getDescricao(alunoDTO.curso());

        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.nome());
        aluno.setRa(alunoDTO.ra());
        aluno.setCurso(disciplina);
        aluno.setDataNascimento(alunoDTO.dataNascimento());

        return aluno;

    }

}
