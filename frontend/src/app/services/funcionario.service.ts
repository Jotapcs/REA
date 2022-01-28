import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from 'src/assets/Model/funcionario';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService{
  constructor(private http: HttpClient) { }

  listar(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>('http://localhost:8080/BackEndRea_war/webapi/funcionario')
  }

  inserir(funcionario: Funcionario): Observable<void> {
    return this.http.post<void>('http://localhost:8080/BackEndRea_war/webapi/funcionario', funcionario)
  }

  atualizar(funcionario: Funcionario): Observable<void> {
    return this.http.put<void>('http://localhost:8080/BackEndRea_war/webapi/funcionario', funcionario)
  }

  excluir(id: number): Observable<void> {
    return this.http.request<void>('DELETE', 'http://localhost:8080/BackEndRea_war/webapi/funcionario', {
      headers: new HttpHeaders({
          'Content-Type': 'application/json',
      }),
      body: { id: id }
  });
  }
}
