import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuncionarioComponent } from './views/funcionario/funcionario.component';
import { ContratadosComponent } from './views/contratados/contratados.component';

const routes: Routes = [
  { path: 'funcionario', component: FuncionarioComponent},
  { path: 'contratados', component: ContratadosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
