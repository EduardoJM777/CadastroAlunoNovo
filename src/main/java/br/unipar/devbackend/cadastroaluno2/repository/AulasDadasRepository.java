package br.unipar.devbackend.cadastroaluno2.repository;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulasDadasRepository extends JpaRepository<AulasDadas, Long> {
}
