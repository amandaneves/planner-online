import { Component, EventEmitter, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { catchError, Observable, of } from 'rxjs';

import { AdicionarTarefaModalComponent } from '../adicionar-tarefa-modal/adicionar-tarefa-modal.component';
import { Tarefa } from '../models/tarefa';
import { TarefasService } from './../services/tarefas.service';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.scss']
})
export class TarefasComponent {

  @Output() atualizarLista = new EventEmitter(false);
  tarefas$: Observable<Tarefa[]> | null = null;

  constructor(
    private tarefasService: TarefasService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) {
    this.buscarTarefas();
  }

  buscarTarefas() {
    this.tarefas$ = this.tarefasService.getAll()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar tarefas.');
        return of([])
      })
    );
  }

  abrirModalAdicionar(modal: any) {
    const modalAdicionar = this.modalService.open(AdicionarTarefaModalComponent, { centered: true });
    modalAdicionar.componentInstance.atualizarLista.subscribe((_event: void) => this.buscarTarefas());
  }

  mudarStatusTarefa(tarefa: Tarefa) {
    let novoStatus = !tarefa.concluida;
    tarefa.concluida = novoStatus;

    this.tarefasService.save(tarefa)
      .subscribe(
        result => {
          if (novoStatus)
            this.onSuccess("Parabéns! Tarefa concluída!");
          else this.onSuccess("Status da tarefa alterado.");
        },
        error => {
          this.onError("Erro ao tentar concluir tarefa.");
        }
      );
  }

  // TODO corrigir retorno
  removerTarefa(id: string) {
    this.tarefasService.remove(id)
      .subscribe(
        () => this.onInfo('Tarefa removida.'),
        () => this.onInfo('Tarefa removida.')
      );
  }

  onInfo(mensagem: string) {
    this.toastr.info(mensagem);
    this.buscarTarefas();
  }

  onSuccess(mensagem: string) {
    this.toastr.success(mensagem, 'Sucesso');
    this.buscarTarefas();
  }

  onError(mensagem: string) {
    return this.toastr.error(mensagem, 'Error');
  }
}
