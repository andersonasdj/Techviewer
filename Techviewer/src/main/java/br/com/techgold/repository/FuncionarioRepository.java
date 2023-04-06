package br.com.techgold.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.techgold.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query(value = "select * from Funcionario f where f.status = 'Ativo'", nativeQuery = true )
	public List<Funcionario> listarAtivos();
	
	@Query(value = "select * from Funcionario f where f.status = 'Inativo'", nativeQuery = true )
	public List<Funcionario> listarInativos();

}
