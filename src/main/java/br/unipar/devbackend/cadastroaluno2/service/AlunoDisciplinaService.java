package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.dto.Att1BimDTO;
import br.unipar.devbackend.cadastroaluno2.dto.Att2BimDTO;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {
    private final AlunoDisciplinaRepository adRepository;

    @Autowired
    public AlunoDisciplinaService(AlunoDisciplinaRepository adRepository) {
        this.adRepository = adRepository;
    }

    public AlunoDisciplina salvar(AlunoDisciplina alunoDisciplina) {
        return adRepository.save(alunoDisciplina);
    }

    public List<AlunoDisciplina> listar() {
        return adRepository.findAll();
    }

    public AlunoDisciplina atualizar(Long id, AlunoDisciplina adAtualizada) {
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

    public AlunoDisciplina Att1Bim(Long idAluno, Long idDisciplina, Att1BimDTO dto) {

        AlunoDisciplina alunoDisciplina = adRepository
                .findByAlunoIdAndDisciplinaId(idAluno, idDisciplina)
                .orElseThrow(() -> new RuntimeException("Relação aluno-disciplina não encontrada"));

        alunoDisciplina.setNota1Bim(dto.nota1bim());
        alunoDisciplina.setFaltas1Bim(dto.faltas1bim());

        return adRepository.save(alunoDisciplina);
    }

    public AlunoDisciplina Att2Bim(Long idAluno, Long idDisciplina, Att2BimDTO dto) {

        AlunoDisciplina alunoDisciplina = adRepository
                .findByAlunoIdAndDisciplinaId(idAluno, idDisciplina)
                .orElseThrow(() -> new RuntimeException("Relação aluno-disciplina não encontrada"));

        alunoDisciplina.setNota2Bim(dto.nota2bim());
        alunoDisciplina.setFaltas2Bim(dto.faltas2bim());

        return adRepository.save(alunoDisciplina);
    }


    public AlunoDisciplina buscarPorId(Long id) {
        return adRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrada(o)"));
    }
}