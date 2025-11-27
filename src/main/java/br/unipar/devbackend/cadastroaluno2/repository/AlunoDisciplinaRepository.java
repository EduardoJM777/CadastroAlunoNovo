package br.unipar.devbackend.cadastroaluno2.repository;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Long> {
    Optional<AlunoDisciplina> findByAlunoIdAndDisciplinaId(Long alunoId, Long disciplinaId);
    List<AlunoDisciplina> findByAlunoId(Long idAluno);



}
