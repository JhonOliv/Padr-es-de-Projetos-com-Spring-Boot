package edu.dio.lab_padroes_projetos_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dio.lab_padroes_projetos_spring.model.Cliente;
import edu.dio.lab_padroes_projetos_spring.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}
	
	@GetMapping()
	public ResponseEntity<Iterable<Cliente>> buscarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,  Cliente cliente){
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping
	public ResponseEntity<Cliente> deletar(@PathVariable Long id){
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	

}
