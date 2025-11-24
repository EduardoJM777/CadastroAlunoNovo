package br.unipar.devbackend.cadastroaluno2.dto;

public record AlunoDisciplinaDTO (Long id,
                                  Long alunoId,
                                  Long disciplinaId,
                                  Double nota1bim,
                                  Double nota2bim,
                                  Integer falta1bim,
                                  Integer falta2bim,
                                  Boolean matriculado,
                                  Enum situacao){}
