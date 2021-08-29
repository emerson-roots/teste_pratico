package teste_pratico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste_pratico.domain.MovimentacaoConteiner;

@Repository
public interface MovimentacaoConteinerRepository extends JpaRepository<MovimentacaoConteiner, Long>{

	// namespaces conforme documentação
	// fonte: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
	List<MovimentacaoConteiner> findAllByOrderByConteinerIdDesc();

}
