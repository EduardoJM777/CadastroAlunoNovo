package br.unipar.devbackend.cadastroaluno2.dto;

public record ProfessorDTO(Long id,
                           String nome,
                           String matricula,
                           String cpf,
                           String dtAdmissao) {
}
