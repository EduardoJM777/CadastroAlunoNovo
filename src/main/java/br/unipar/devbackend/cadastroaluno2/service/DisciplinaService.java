package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private final DisciplinaRepository disciplinaRepository;
    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina salvar(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listar(){
        return disciplinaRepository.findAll();
    }

    public Disciplina atualizar(Long id, Disciplina ds){
        return disciplinaRepository.findById(id).map(disciplina -> {
            disciplina.setCodigo(ds.getCodigo());
            disciplina.setDescricao(ds.getDescricao());
            disciplina.setEmenta(ds.getEmenta());
            disciplina.setProfessor(ds.getProfessor());
            return disciplinaRepository.save(disciplina);
        }).orElseThrow(()-> new RuntimeException("Disciplina não encontrada"));
    }

    public Disciplina buscarPorId(Long id){
        return disciplinaRepository.findById(id).orElseThrow(()->new RuntimeException("Id não encontrado"));
    }
}
