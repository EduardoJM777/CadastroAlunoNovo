package br.unipar.devbackend.cadastroaluno2.dto;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;

public record LancamentoDTO(Long id,
                            Aluno aluno,
                            Disciplina disciplina) {
}
