import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Tarefa } from '../models/tarefa';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  private readonly API = "api/tarefas";

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Tarefa[]>(this.API);
  }

  save(tarefa: Partial<Tarefa>) {
    // Dados temporariamente
    tarefa.ordem = 0;
    tarefa.data = "14/10/2023";
    if (tarefa.id) {
      return this.update(tarefa);
    }
    return this.create(tarefa);
  }

  private create(tarefa: Partial<Tarefa>) {
    return this.httpClient.post<Tarefa>(this.API, tarefa);
  }

  private update(tarefa: Partial<Tarefa>) {
    return this.httpClient.put<Tarefa>(`${this.API}/${tarefa.id}`, tarefa);
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
