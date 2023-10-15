import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Categoria } from '../models/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  private readonly API = "api/categorias";

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Categoria[]>(this.API);
  }

  save(categoria: Partial<Categoria>) {
    if (categoria.id) {
      return this.update(categoria);
    }
    return this.create(categoria);
  }

  private create(categoria: Partial<Categoria>) {
    return this.httpClient.post<Categoria>(this.API, categoria);
  }

  private update(categoria: Partial<Categoria>) {
    return this.httpClient.put<Categoria>(`${this.API}/${categoria.id}`, categoria);
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`);
  }
}
