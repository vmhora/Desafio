package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Conta;
import com.capgemini.model.ResponseModel;
import com.capgemini.service.dto.ContaDTO;

public interface ContaService {
	
	Conta getSaldo(Long contaId);

	ResponseModel sacar(ContaDTO conta);

	List<Conta> getContas();

	ResponseModel depositar(ContaDTO conta);
}
