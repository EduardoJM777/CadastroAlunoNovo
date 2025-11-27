package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AlunoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double nota1Bim;
    private Double nota2Bim;
    private Integer faltas1Bim;
    private Integer faltas2Bim;
    private Boolean matriculado;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;

}
