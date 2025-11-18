package br.unipar.devbackend.cadastroaluno2.dto;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;

public record AlunoDisciplinaDTO (Long id,
                                  String aluno,
                                  String disciplina,
                                  Double nota1bim,
                                  Double nota2bim,
                                  Integer falta1bim,
                                  Integer falta2bim,
                                  Boolean matriculado,
                                  Enum situacao) {

    public AlunoDisciplinaDTO(Aluno aluno,
                              Disciplina disciplina,
                              Double nota1Bim,
                              Double nota2Bim,
                              Integer faltas1Bim,
                              Integer faltas2Bim,
                              Boolean matriculado,
                              Enum situacao) {
    }

}
