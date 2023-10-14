import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TarefasRoutingModule } from './tarefas-routing.module';
import { TarefasComponent } from './tarefas/tarefas.component';
import { TarefasModalAdicionarComponent } from './tarefas-modal-adicionar/tarefas-modal-adicionar.component';


@NgModule({
  declarations: [
    TarefasComponent,
    TarefasModalAdicionarComponent
  ],
  imports: [
    CommonModule,
    TarefasRoutingModule
  ]
})
export class TarefasModule { }
