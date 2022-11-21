import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NovaReservaComponent } from './views/nova-reserva/novareserva.component';
import { ReservasComponent } from './views/reservas/reservas.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  { path: 'nova-reserva', component: NovaReservaComponent},
  { path: 'reservas', component: ReservasComponent},
  { path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
