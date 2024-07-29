package edu.dio.lab_padroes_projetos_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne
	private Endereco endereco;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
//	
}
