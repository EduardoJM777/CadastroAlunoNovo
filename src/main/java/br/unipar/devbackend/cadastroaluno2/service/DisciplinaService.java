package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final AlunoDisciplinaRepository adRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository, AlunoDisciplinaRepository adRepository){
        this.disciplinaRepository = disciplinaRepository;
        this.adRepository = adRepository;
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

    public Disciplina buscarPorCodigo(String codigo){
        return disciplinaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com código: " + codigo));
    }

    public List<Disciplina> listarPorProfessor(Long idProfessor){
        return disciplinaRepository.findByProfessorId(idProfessor);
    }

    public List<Aluno> listarAlunosMatriculados(Long idDisciplina){

        List<AlunoDisciplina> registros =
                adRepository.findByDisciplinaIdAndMatriculadoTrue(idDisciplina);

        return registros.stream()
                .map(AlunoDisciplina::getAluno)
                .toList();
    }

}
