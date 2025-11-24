package br.unipar.devbackend.cadastroaluno2.dto;

import java.util.Date;

public record AulasDadasDTO(Long id,
                            Long idDisciplina,
                            Date data,
                            String observacoes) {}
