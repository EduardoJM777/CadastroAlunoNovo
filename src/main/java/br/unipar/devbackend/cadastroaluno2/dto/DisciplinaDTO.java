package br.unipar.devbackend.cadastroaluno2.dto;

import br.unipar.devbackend.cadastroaluno2.model.Professor;

public record DisciplinaDTO(Long id,
                            String codigo,
                            String descricao,
                            String ementa,
                            Long idProfessor) {}
