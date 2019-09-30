import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Conta } from '../model/conta.model';
import { Response } from '../model/reponse.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ContaService {

  constructor(private http:HttpClient) {}

  	private contaUrl = 'http://localhost:8080/api';

  public getSaldo(conta) {
    return this.http.get<Conta>(this.contaUrl + "/obterSaldo/"+ conta.id);
  }

  public getContas() {
    return this.http.get<Conta[]>(this.contaUrl + "/contas");
  }

  public sacar(conta) {
    return this.http.put<Response>(this.contaUrl + "/sacar", conta);
  }

  public depositar(conta) {
    return this.http.put<Response>(this.contaUrl + "/depositar", conta);
  }
  
}