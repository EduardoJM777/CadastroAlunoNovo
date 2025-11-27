package br.unipar.devbackend.cadastroaluno2.dto;

import java.util.List;

public record BoletimDTO(
        String aluno,
        List<BoletimItemDTO> boletim
) {}
