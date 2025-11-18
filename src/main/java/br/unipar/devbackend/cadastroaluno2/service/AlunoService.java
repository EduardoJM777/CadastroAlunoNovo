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
        return alunos.stream().map(AlunoMapper::alunoToDTO).toList();
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        return repository.findById(id).map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setRa(alunoAtualizado.getRa());
            aluno.setDataMatricula(alunoAtualizado.getDataMatricula());
            return repository.save(aluno);
        }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

}
