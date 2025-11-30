package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    private final AlunoRepository repository;

    @Autowired
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public Aluno salvar(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> listar(){
        return repository.findAll();
    }

   public Aluno atualizar(Long id, Aluno alunoAtualizado){
       return repository.findById(id).map(aluno -> {
          aluno.setNome(alunoAtualizado.getNome());
          aluno.setCpf(alunoAtualizado.getCpf());
          aluno.setRa(alunoAtualizado.getRa());
          aluno.setAnoIngresso(alunoAtualizado.getAnoIngresso());
          aluno.setPeriodoAtual(alunoAtualizado.getPeriodoAtual());
          aluno.setDisciplina(alunoAtualizado.getDisciplina());
          return repository.save(aluno);
      }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

}
