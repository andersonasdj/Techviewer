package br.com.techgold.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techgold.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

}
