import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DadosDaReserva } from 'src/assets/Model/DadosDaReserva';

@Injectable({
  providedIn: 'root'
})
export class DadosDaReservaService{
  constructor(private http: HttpClient) { }

  listar(): Observable<DadosDaReserva[]> {
    return this.http.get<DadosDaReserva[]>('http://localhost:8080/BackEndRea_war/webapi/reserva')
  }

  inserir(dadosDaReserva: DadosDaReserva): Observable<void> {
    return this.http.post<void>('http://localhost:8080/BackEndRea_war/webapi/reserva', dadosDaReserva)
  }

  atualizar(dadosDaReserva: DadosDaReserva): Observable<void> {
    return this.http.put<void>('http://localhost:8080/BackEndRea_war/webapi/reserva', dadosDaReserva)
  }

  excluir(id: number): Observable<void> {
    return this.http.request<void>('DELETE', 'http://localhost:8080/BackEndRea_war/webapi/reserva', {
      headers: new HttpHeaders({
          'Content-Type': 'application/json',
      }),
      body: { id: id }
  });
  }
}
