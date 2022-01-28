import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Funcionario } from 'src/assets/Model/funcionario';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {


funcionarios = new Array<Funcionario>();
columns = [];
funcionarioEdicao?: Funcionario = undefined;
estaEditando = false;

constructor(private funcionarioService: FuncionarioService) { }

ngOnInit(): void {
  this.listarFuncionarios();
}


listarFuncionarios(): void{
  this.funcionarioService.listar().subscribe(funcionarios => {
    this.funcionarios = funcionarios;
  });
}


salvar(): void{
  if(this.funcionarioEdicao == undefined){
    return;
  }
  if(!this.estaEditando){
  this.funcionarioService.inserir(this.funcionarioEdicao).subscribe(() => {
    this.listarFuncionarios();
    this.cancelar();
  });
}else{
  this.funcionarioService.atualizar(this.funcionarioEdicao).subscribe(() =>{
    this.listarFuncionarios();
    this.cancelar();
  });
  }
}

novoFuncionario() {
  this.funcionarioEdicao = new Funcionario();
  this.estaEditando = false;
}

cancelar() {
  this.funcionarioEdicao = undefined;
  this.estaEditando = false;
}

}
