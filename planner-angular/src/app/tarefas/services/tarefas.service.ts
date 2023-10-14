import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tarefa } from '../models/tarefa';
import { delay } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  private readonly API = "api/tarefas";

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Tarefa[]>(this.API)
    .pipe(
      delay(5000)
    );
  }
}
