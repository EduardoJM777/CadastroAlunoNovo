package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {


    private final AlunoDisciplinaRepository adRepository;

    @Autowired
    public AlunoDisciplinaService(AlunoDisciplinaRepository adRepository){
        this.adRepository = adRepository;
    }

    public AlunoDisciplina salvar(AlunoDisciplina alunoDisciplina){
        return adRepository.save(alunoDisciplina);
    }

    public List<AlunoDisciplina> listar(){
        return adRepository.findAll();
    }

    public AlunoDisciplina atualizar(Long id, AlunoDisciplina adAtualizada){
        return adRepository.findById(id).map(alunoDisciplina -> {
            alunoDisciplina.setNota1Bim(adAtualizada.getNota1Bim());
            alunoDisciplina.setNota2Bim(adAtualizada.getNota2Bim());
            alunoDisciplina.setFaltas1Bim(adAtualizada.getFaltas1Bim());
            alunoDisciplina.setFaltas2Bim(adAtualizada.getFaltas2Bim());
            alunoDisciplina.setMatriculado(adAtualizada.getMatriculado());
            alunoDisciplina.setSituacao(adAtualizada.getSituacao());
            alunoDisciplina.setAluno(adAtualizada.getAluno());
            alunoDisciplina.setDisciplina(adAtualizada.getDisciplina());
            return adRepository.save(alunoDisciplina);
        }).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
    }

    public AlunoDisciplina atualizar1b(Long id, AlunoDisciplina adAtualizada) {
        return adRepository.findById(id).map(alunoDisciplina -> {
            alunoDisciplina.setNota1Bim(adAtualizada.getNota1Bim());
            alunoDisciplina.setFaltas1Bim(adAtualizada.getFaltas1Bim());
            return adRepository.save(alunoDisciplina);
        }).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
    }

        public AlunoDisciplina atualizar2b(Long id, AlunoDisciplina adAtualizada) {
            return adRepository.findById(id).map(alunoDisciplina -> {
                alunoDisciplina.setNota2Bim(adAtualizada.getNota2Bim());
                alunoDisciplina.setFaltas2Bim(adAtualizada.getFaltas2Bim());
                return adRepository.save(alunoDisciplina);
            }).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
        }

    public AlunoDisciplina buscarPorId(Long id){
        return adRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
    }


}
