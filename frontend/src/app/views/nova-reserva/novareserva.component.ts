import { Component, OnInit } from '@angular/core';
import { DadosDaReservaService } from 'src/app/services/dadosdareserva.service';
import { DadosDaReserva } from 'src/assets/Model/DadosDaReserva';

@Component({
  selector: 'app-novareserva',
  templateUrl: './novareserva.component.html',
  styleUrls: ['./novareserva.component.css']
})
export class NovaReservaComponent implements OnInit {

dadosDaReservas = new Array<DadosDaReserva>();
columns = [];
reservaEdicao?: DadosDaReserva = undefined;
estaEditando = false;

constructor(private dadosDaReservaService: DadosDaReservaService) { }

ngOnInit(): void {
  this.listarReservas();
}

listarReservas(): void{
  this.dadosDaReservaService.listar().subscribe(reserva => {
    this.dadosDaReservas = reserva;
  });
}

salvar(): void{
  if(this.reservaEdicao == undefined){
    return;
  }
  if(!this.estaEditando){
  this.dadosDaReservaService.inserir(this.reservaEdicao).subscribe(() => {
    this.listarReservas();
    this.cancelar();
  });
}else{
  this.dadosDaReservaService.atualizar(this.reservaEdicao).subscribe(() =>{
    this.listarReservas();
    this.cancelar();
  });
  }
}

novoFuncionario() {
  this.reservaEdicao = new DadosDaReserva();
  this.estaEditando = false;
}

cancelar() {
  this.reservaEdicao = undefined;
  this.estaEditando = false;
}

}
