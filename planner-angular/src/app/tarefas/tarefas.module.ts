import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AdicionarTarefaModalComponent } from './adicionar-tarefa-modal/adicionar-tarefa-modal.component';
import { TarefasRoutingModule } from './tarefas-routing.module';
import { TarefasComponent } from './tarefas/tarefas.component';

@NgModule({
  declarations: [
    TarefasComponent,
    AdicionarTarefaModalComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TarefasRoutingModule
  ],
  providers: [],
})
export class TarefasModule { }
