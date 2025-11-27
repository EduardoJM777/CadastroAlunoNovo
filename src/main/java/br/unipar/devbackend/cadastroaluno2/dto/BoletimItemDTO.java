package br.unipar.devbackend.cadastroaluno2.dto;

public record BoletimItemDTO(
        String disciplina,
        Double nota1Bim,
        Double nota2Bim,
        Integer faltas,
        Double mediaFinal,
        String situacao,
        Boolean matriculado
) {}