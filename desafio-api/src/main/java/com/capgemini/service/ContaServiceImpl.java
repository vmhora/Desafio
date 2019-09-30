package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Conta;
import com.capgemini.model.ResponseModel;
import com.capgemini.repository.ContaRepository;
import com.capgemini.service.dto.ContaDTO;
import com.capgemini.service.mapper.ContaMapper;
import com.capgemini.web.rest.errors.MessageVM;

@Service
@Transactional
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
//	@Autowired
//	private ContaMapper contaMapper;
	
	@Override
	public Conta getSaldo(Long contaId) {
		return contaRepository.getOne(contaId);
	}

	@Override
	public ResponseModel sacar(ContaDTO conta) {
		Conta c = contaRepository.getOne(conta.getId());

		if (c.getSaldo().compareTo(conta.getValorSaqueDeposito()) < 0) {
			return new ResponseModel("Saldo Insuficiente", null);
		}
		c.setSaldo(c.getSaldo() - conta.getValorSaqueDeposito());
		contaRepository.save(c);
		
		return new ResponseModel("Saque Realizado", c);
	}

	@Override
	public List<Conta> getContas() {
		return contaRepository.findAll();
	}

	@Override
	public ResponseModel depositar(ContaDTO conta) {
		Conta c = contaRepository.getOne(conta.getId());
        c.setSaldo(c.getSaldo() + conta.getValorSaqueDeposito());
        contaRepository.save(c);
		return new ResponseModel("Depósito Realizado com Sucesso!", contaRepository.save(c));
	}

}
