package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Professor;
import br.unipar.devbackend.cadastroaluno2.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }

    public Professor buscarPorId(Long id){
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
    }

    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    public Professor atualizar(Long id, Professor pf){
        return professorRepository.findById(id).map(professor -> {
            professor.setNome(pf.getNome());
            professor.setCpf(pf.getCpf());
            professor.setMatricula((pf.getMatricula()));
            return professorRepository.save(professor);
        }).orElseThrow(() -> new RuntimeException("Não encontrado"));
    }
}
