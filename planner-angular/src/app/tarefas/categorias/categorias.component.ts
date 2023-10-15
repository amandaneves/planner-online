import { Component, EventEmitter, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { catchError, Observable, of } from 'rxjs';

import { AdicionarCategoriaModalComponent } from '../adicionar-categoria-modal/adicionar-categoria-modal.component';
import { Categoria } from '../models/categoria';
import { CategoriasService } from '../services/categorias.service';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.scss']
})
export class CategoriasComponent {

  @Output() atualizarLista = new EventEmitter(false);
  categorias$: Observable<Categoria[]> | null = null;

  constructor(
    private categoriaService: CategoriasService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) {
    this.buscarCategorias();
  }

  buscarCategorias() {
    this.categorias$ = this.categoriaService.getAll()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar categorias.');
        return of([])
      })
    );
  }

  abrirModalAdicionar(modal: any) {
    const modalAdicionar = this.modalService.open(AdicionarCategoriaModalComponent, { centered: true });
    modalAdicionar.componentInstance.atualizarLista.subscribe((_event: void) => this.buscarCategorias());
  }

  // TODO corrigir retorno
  removerCategoria(id: string) {
    this.categoriaService.remove(id)
      .subscribe(
        () => this.onInfo('Categoria removida.'),
        () => this.onInfo('Categoria removida.')
      );
  }

  onInfo(mensagem: string) {
    this.toastr.info(mensagem);
    this.buscarCategorias();
  }

  onSuccess(mensagem: string) {
    this.toastr.success(mensagem, 'Sucesso');
    this.buscarCategorias();
  }

  onError(mensagem: string) {
    return this.toastr.error(mensagem, 'Error');
  }
}
