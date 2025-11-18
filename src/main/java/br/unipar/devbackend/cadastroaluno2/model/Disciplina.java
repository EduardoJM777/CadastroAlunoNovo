package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Disciplina {

    private Long id;
    private String codigo;
    private String descricao;
    private String ementa;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
