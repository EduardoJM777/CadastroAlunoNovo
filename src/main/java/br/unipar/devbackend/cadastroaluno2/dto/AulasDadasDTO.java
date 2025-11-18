package br.unipar.devbackend.cadastroaluno2.dto;

import java.util.Date;

public record AulasDadasDTO(Long id,
                            String disciplina,
                            Date data,
                            String observacoes) {
}
