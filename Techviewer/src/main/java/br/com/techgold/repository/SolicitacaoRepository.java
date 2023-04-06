package br.com.techgold.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.techgold.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

	@Query(value = "select * from Solicitacao s where s.status != 'Finalizado' and s.status != 'Excluida' ORDER BY s.id ASC", nativeQuery = true)
	public List<Solicitacao> listarNaoFinalizados();
}
