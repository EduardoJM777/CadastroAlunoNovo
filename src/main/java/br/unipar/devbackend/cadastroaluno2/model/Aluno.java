package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String ra;
    private LocalDate dataNascimento;
    private LocalDate dataMatricula;
    private LocalDate periodoAtual;

    @ManyToOne
    private Disciplina curso;

}
