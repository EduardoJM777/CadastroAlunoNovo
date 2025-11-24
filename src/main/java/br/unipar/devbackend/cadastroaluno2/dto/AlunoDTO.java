package br.unipar.devbackend.cadastroaluno2.dto;

import java.time.LocalDate;

public record AlunoDTO(Long id,
                       String cpf,
                       String ra,
                       String nome,
                       Integer anoIngresso,
                       Integer periodoAtual,
                       Long idDisciplina){}
