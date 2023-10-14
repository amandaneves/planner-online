import { TarefasService } from './../services/tarefas.service';
import { Component, OnInit } from '@angular/core';
import { Tarefa } from '../models/tarefa';
import { Router } from '@angular/router';
import { Observable, catchError, of } from 'rxjs';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.scss']
})
export class TarefasComponent implements OnInit {

  tarefas$: Observable<Tarefa[]> | null = null;

  constructor(
    private tarefasService: TarefasService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.buscarTarefas();
  }

  buscarTarefas() {
    this.tarefas$ = this.tarefasService.getAll()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar cursos.');
        return of([])
      })
    );
  }

  onError(errorMsg: string) {
    return false;
  }

}
