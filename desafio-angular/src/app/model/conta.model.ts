import { Pessoa } from './pessoa.model';

export class Conta {

    id: number;
    numero: string;
    saldo: number;
    valorSaqueDeposito: number;
    cliente: Pessoa
  }