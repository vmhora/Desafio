package com.capgemini;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.model.Conta;
import com.capgemini.model.Pessoa;
import com.capgemini.repository.PessoaRepository;

@SpringBootApplication
public class DesafioCapgeminiApplication {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioCapgeminiApplication.class, args);
	}
	
	@PostConstruct
	private void initDb() {
		Pessoa p = new Pessoa();
		p.setNome("João");
		
		Conta c1 = new Conta();
		c1.setCliente(p);
		c1.setNumero("123456789");
		c1.setSaldo(8489.00);
		
		Conta c2 = new Conta();
		c2.setCliente(p);
		c2.setNumero("987654321");
		c2.setSaldo(9800.00);
		
		p.getListaContas().add(c1);
		p.getListaContas().add(c2);
		
		pessoaRepository.save(p);
	}
}
