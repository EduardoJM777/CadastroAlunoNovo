package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AulasDadasPresencas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean falta;

    @ManyToOne
    private AulasDadas aulasDadas;

    @ManyToOne
    private Aluno aluno;

}
