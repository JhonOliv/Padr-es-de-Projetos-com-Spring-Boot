package edu.dio.lab_padroes_projetos_spring.service;

import org.springframework.stereotype.Service;

import edu.dio.lab_padroes_projetos_spring.model.Cliente;
@Service
public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir (Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);

}
