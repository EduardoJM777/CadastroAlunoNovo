package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;

}
