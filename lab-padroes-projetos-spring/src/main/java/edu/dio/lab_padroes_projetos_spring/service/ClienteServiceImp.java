package edu.dio.lab_padroes_projetos_spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dio.lab_padroes_projetos_spring.model.Cliente;
import edu.dio.lab_padroes_projetos_spring.model.Endereco;
import edu.dio.lab_padroes_projetos_spring.repository.ClienteRepository;
import edu.dio.lab_padroes_projetos_spring.repository.EnderecoRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clientRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = clientRepository.findById(id);
		
		if(cliente.isPresent()) {
			return cliente.get();
		}
		
			return null;
		
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		salvarClienteComCep(cliente);
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
		Optional<Cliente> clienteDB = clientRepository.findById(id);
		
		if(clienteDB.isPresent()) {
			salvarClienteComCep(cliente);
		}

		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
		
	}
	
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consutarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
			
		});
		
		cliente.setEndereco(endereco);
		clientRepository.save(cliente);
	}

}
