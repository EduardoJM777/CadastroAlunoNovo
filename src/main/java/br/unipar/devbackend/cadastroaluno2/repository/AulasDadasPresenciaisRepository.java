package br.unipar.devbackend.cadastroaluno2.repository;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresenciais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulasDadasPresenciaisRepository extends JpaRepository<AulasDadasPresenciais, Long> {
}
