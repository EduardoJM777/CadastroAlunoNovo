package br.unipar.devbackend.cadastroaluno2.repository;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
