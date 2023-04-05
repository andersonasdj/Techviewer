package br.com.techgold.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techgold.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
