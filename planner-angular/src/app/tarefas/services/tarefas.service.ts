import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Tarefa } from '../models/tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  private readonly API = "api/tarefas";

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Tarefa[]>(this.API);
  }

  save(tarefa: Tarefa) {
    // Dados temporariamente
    tarefa.ordem = 0;
    tarefa.data = "14/10/2023";
    return this.httpClient.post<Tarefa>(this.API, tarefa);
  }
}
