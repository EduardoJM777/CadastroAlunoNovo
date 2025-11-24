package br.unipar.devbackend.cadastroaluno2.dto;

public record AulasDadasPresencasDTO(Long id,
                                     Boolean falta,
                                     Long idAulasDadas,
                                     Long idAluno) {}
