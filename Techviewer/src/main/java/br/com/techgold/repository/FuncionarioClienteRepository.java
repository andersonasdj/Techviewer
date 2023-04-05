package br.com.techgold.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techgold.model.FuncionarioCliente;

public interface FuncionarioClienteRepository extends JpaRepository<FuncionarioCliente, Long> {

}
