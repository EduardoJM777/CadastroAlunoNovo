package br.unipar.devbackend.cadastroaluno2.dto;

import java.time.LocalDate;

public record AlunoDTO(String ra,
                       String nome,
                       LocalDate dataNascimento,
                       String curso){
}
