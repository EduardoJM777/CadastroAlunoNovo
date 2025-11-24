package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.dto.AlunoDTO;
import br.unipar.devbackend.cadastroaluno2.mapper.AlunoMapper;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    AlunoRepository repository;

    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public List<AlunoDTO> getAllAlunos(){
        List<Aluno> alunos = repository.findAll();
        return alunos.stream().map(AlunoMapper::toDTO).toList();
    }



}
