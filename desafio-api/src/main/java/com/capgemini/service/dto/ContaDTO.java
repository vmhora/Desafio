package com.capgemini.service.dto;

public class ContaDTO {
	
	private Long id;
	
	private String numero;
	
	private Double saldo;
	
	//private Pessoa cliente;
	
	private Double valorSaqueDeposito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getValorSaqueDeposito() {
		return valorSaqueDeposito;
	}

	public void setValorSaqueDeposito(Double valorSaqueDeposito) {
		this.valorSaqueDeposito = valorSaqueDeposito;
	}

//	public Pessoa getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Pessoa cliente) {
//		this.cliente = cliente;
//	}


	
}
