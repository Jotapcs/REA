import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Funcionario } from 'src/assets/Model/funcionario';

@Component({
  selector: 'app-contratados',
  templateUrl: './contratados.component.html',
  styleUrls: ['./contratados.component.css']
})
export class ContratadosComponent implements OnInit {


contratados = new Array<Funcionario>();
columns = ['id','nome','cpf','rg','telefone','email','dataNascimento','dataContrato','funcao','numeroContrato','actions'];
contratadosEdicao?: Funcionario = undefined;
estaEditando = false;

constructor(private contratadosService: FuncionarioService) { }

ngOnInit(): void {
  this.listarContratados();
}

listarContratados(): void{
  this.contratadosService.listar().subscribe(contratados => {
    this.contratados = contratados;
  });
}

salvar(): void{
  if(this.contratadosEdicao == undefined){
    return;
  }
  if(!this.estaEditando){
  this.contratadosService.inserir(this.contratadosEdicao).subscribe(() => {
    this.listarContratados();
    this.cancelar();
  });
}else{
  this.contratadosService.atualizar(this.contratadosEdicao).subscribe(() =>{
    this.listarContratados();
    this.cancelar();
  });
  }
}

cancelar() {
  this.contratadosEdicao = undefined;
  this.estaEditando = false;
}
selecionarContratados(contratados: Funcionario) {
  this.contratadosEdicao = contratados;
  this.estaEditando = true;
}

excluir(contratados: Funcionario) {
  const resposta = confirm(` ${contratados.id} vai ser removido, tem certeza?`);
  if(resposta && contratados && contratados.id){
    this.contratadosService.excluir(contratados.id).subscribe(() => {
      this.listarContratados();
    });
  }
}

}
