import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Conta } from '../model/conta.model';
import { ContaService } from './conta.service';
import { Response } from '../model/reponse.model';

@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styles: []
})
export class ContaComponent implements OnInit {

  contas: Conta[];
  conta: Conta = new Conta();
  exibirSaldo: boolean = false;
  exibirInput: boolean = false;
  tipoOperacao: number = 0;
  response: Response;
  cliente: string;

  constructor(private router: Router, private contaService: ContaService) {

  }

  ngOnInit() {
    this.contaService.getContas()
      .subscribe( data => {
        this.contas = data;
        this.cliente = data[0].cliente.nome;
      });
  };

  getSaldo(conta: Conta): void {
    this.contaService.getSaldo(conta)
      .subscribe( data => {
        this.conta = data;
      })
     this.exibirSaldo = true;
     this.exibirInput = false;
  };

  sacar(conta: Conta): void {
    this.contaService.sacar(conta)
      .subscribe( data => {
        this.response = data;
      })
    
  };

  depositar(conta: Conta): void {
    this.contaService.depositar(conta)
      .subscribe( data => {
        this.response = data;
      })
    
  };

  atualizarSaldo(conta: Conta): void{
    this.conta = conta;
    
    if(this.tipoOperacao == 1){
      this.sacar(conta);
    }else{
      this.depositar(conta);
    }
  }

  selecionarOperacao(conta: Conta, tipoOperacao: number): void{
    this.conta = conta;
    this.conta.valorSaqueDeposito = 0;
    this.tipoOperacao = tipoOperacao;
    this.exibirInput = true;
    this.exibirSaldo = false;
    this.response = null;
  }

}