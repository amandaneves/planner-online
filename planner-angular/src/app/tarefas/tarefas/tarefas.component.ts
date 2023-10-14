import { TarefasService } from './../services/tarefas.service';
import { Component, OnInit } from '@angular/core';
import { Tarefa } from '../models/tarefa';
import { Observable, catchError, of } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.scss']
})
export class TarefasComponent implements OnInit {

  tarefas$: Observable<Tarefa[]> | null = null;

  constructor(
    private tarefasService: TarefasService,
    public toastr: ToastrService
  ) {
  }

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
  }

  onError(mensagem: string) {
    return this.toastr.error(mensagem, 'Error');
  }
}
