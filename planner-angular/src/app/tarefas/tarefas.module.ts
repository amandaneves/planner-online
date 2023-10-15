import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AdicionarTarefaModalComponent } from './adicionar-tarefa-modal/adicionar-tarefa-modal.component';
import { TarefasRoutingModule } from './tarefas-routing.module';
import { TarefasComponent } from './tarefas/tarefas.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { AdicionarCategoriaModalComponent } from './adicionar-categoria-modal/adicionar-categoria-modal.component';

@NgModule({
  declarations: [
    TarefasComponent,
    AdicionarTarefaModalComponent,
    CategoriasComponent,
    AdicionarCategoriaModalComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TarefasRoutingModule
  ],
  providers: [],
})
export class TarefasModule { }
