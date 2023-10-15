import { Component, EventEmitter, OnInit, Output } from '@angular/core';
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
export class TarefasComponent implements OnInit {

  @Output() atualizarLista = new EventEmitter(false);
  tarefas$: Observable<Tarefa[]> | null = null;

  constructor(
    private tarefasService: TarefasService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
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
    console.log("buscar 1");
  }

  onError(mensagem: string) {
    return this.toastr.error(mensagem, 'Error');
  }

  openModalAdicionar(modal: any) {
    const modalAdicionar = this.modalService.open(AdicionarTarefaModalComponent, { centered: true });
    modalAdicionar.componentInstance.atualizarLista.subscribe((_event: void) => this.buscarTarefas());
  }

}
