package br.unipar.devbackend.cadastroaluno2.dto;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;

public record AulasDadasPresenciaisDTO(Long id,
                                       Boolean falta,
                                       AulasDadas aulasDadas,
                                       Aluno aluno) {
}
