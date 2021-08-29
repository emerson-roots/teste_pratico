package teste_pratico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste_pratico.domain.Conteiner;

@Repository
public interface ConteinerRepository extends JpaRepository<Conteiner, Long>{

}
