package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String ra;
    private Integer anoIngresso;
    private Integer periodoAtual;

    @ManyToOne
    private Disciplina disciplina;

}
