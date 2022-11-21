import { Component, OnInit } from '@angular/core';
import { DadosDaReservaService } from 'src/app/services/dadosdareserva.service';
import { DadosDaReserva } from 'src/assets/Model/DadosDaReserva';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css']
})
export class ReservasComponent implements OnInit {

reservas = new Array<DadosDaReserva>();
columns = ['id','nome','cpf','rg','telefone','email','dataNascimento','dataCheckin','dataCheckout','numeroAcompanhantes','actions'];
reservasEdicao?: DadosDaReserva = undefined;
estaEditando = false;

constructor(private reservaService: DadosDaReservaService) { }

ngOnInit(): void {
  this.listarReservas();
}

listarReservas(): void{
  this.reservaService.listar().subscribe(reservas => {
    this.reservas = reservas;
  });
}

salvar(): void{
  if(this.reservasEdicao == undefined){
    return;
  }
  if(!this.estaEditando){
  this.reservaService.inserir(this.reservasEdicao).subscribe(() => {
    this.listarReservas();
    this.cancelar();
  });
}else{
  this.reservaService.atualizar(this.reservasEdicao).subscribe(() =>{
    this.listarReservas();
    this.cancelar();
  });
  }
}

cancelar() {
  this.reservasEdicao = undefined;
  this.estaEditando = false;
}
selecionarReserva(reservas: DadosDaReserva) {
  this.reservasEdicao = reservas;
  this.estaEditando = true;
}

excluir(reservas: DadosDaReserva) {
  const resposta = confirm(` ${reservas.id} vai ser removido, tem certeza?`);
  if(resposta && reservas && reservas.id){
    this.reservaService.excluir(reservas.id).subscribe(() => {
      this.listarReservas();
    });
  }
}
}
