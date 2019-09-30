package com.capgemini.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Conta;
import com.capgemini.model.ResponseModel;
import com.capgemini.service.ContaService;
import com.capgemini.service.dto.ContaDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContaResource {
	
	@Autowired
	private ContaService contaService;

	@GetMapping("/contas")
    public List<Conta> getContas() {
    	
   	 	return contaService.getContas();
    }
	
	@GetMapping("/obterSaldo/{contaId}")
    public Conta getSaldoConta(@PathVariable Long contaId) {
    	
		return contaService.getSaldo(contaId);
		
    }
	
	@PutMapping("/sacar")
    public ResponseModel sacar(@RequestBody ContaDTO conta) {
		ResponseModel response = null;
		try {
			response = contaService.sacar(conta);
		}catch(Exception e) {
			new ResponseModel("Erro ao tentar operação", null);
		}
		return response;
    }
	
	@PutMapping("/depositar")
    public ResponseModel depositar(@RequestBody ContaDTO conta) {
		ResponseModel response = null;
		try {
			response = contaService.depositar(conta);
		}catch(Exception e) {
			new ResponseModel("Erro ao tentar operação", null);
		}
		return response;
    }
	 

}
