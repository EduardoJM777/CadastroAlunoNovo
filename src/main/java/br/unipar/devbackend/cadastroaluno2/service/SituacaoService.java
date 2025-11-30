package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Situacao;
import org.springframework.stereotype.Service;

@Service
public class SituacaoService {

    public Situacao calcularSituacao(Double nota1, Double nota2, Integer faltas, Integer totalAulas){

        Double media = (nota1 + nota2) / 2.0;

        Double percentualPresenca = 1 - ((double) faltas / totalAulas);

        Boolean notaOK = media >= 6.0;
        Boolean presencaOK = percentualPresenca >= 0.75;

        if (notaOK && presencaOK){
            return Situacao.APROVADO;
        }

        return Situacao.REPROVADO;
    }


}
