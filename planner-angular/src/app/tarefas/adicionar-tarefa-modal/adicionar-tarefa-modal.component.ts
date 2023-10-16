import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

import { TarefasService } from '../services/tarefas.service';
import { CategoriasService } from './../services/categorias.service';
import { Observable, catchError, of } from 'rxjs';
import { Categoria } from '../models/categoria';

@Component({
  selector: 'app-adicionar-tarefa-modal',
  templateUrl: './adicionar-tarefa-modal.component.html',
  styleUrls: ['./adicionar-tarefa-modal.component.scss']
})
export class AdicionarTarefaModalComponent {

  form: FormGroup;
  erroDescricao: boolean;
  @Output() atualizarLista = new EventEmitter(false);
  categorias$: Observable<Categoria[]> | null = null;

  constructor(
    private activeModalService: NgbActiveModal,
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private tarefasService: TarefasService,
    private categoriasService: CategoriasService
  ) {
    this.buscarCategorias();

    this.form = this.formBuilder.group({
      'descricao': [null],
      'categoriaId': [null]
    });

    this.erroDescricao = false;
  }

  buscarCategorias() {
    this.categorias$ = this.categoriasService.getAll()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar categorias.');
        return of([])
      })
    );
  }

  closeModal() {
    this.form.reset();
    this.erroDescricao = false;
    this.activeModalService.close();
  }

  onSubmit() {
    if (!this.validarTarefa()) {
      return;
    }

    this.tarefasService.save(this.form.value)
      .subscribe(
        result => {
          this.onSuccess("Tarefa adicionada com sucesso!");
        },
        error => {
          this.onError("Erro ao adicionar tarefa.");
        }
      );
  }

  validarTarefa() {
    let camposValidados = true;
    this.erroDescricao = false;
    if (!this.form.value.descricao) {
      camposValidados = false;
      this.erroDescricao = true;
    }

    return camposValidados;
  }

  buscarTarefas() {
    this.atualizarLista.emit(true);
  }

  onSuccess(mensagem: string) {
    this.toastr.success(mensagem, 'Sucesso');
    this.buscarTarefas();
    this.closeModal();
  }

  onError(mensagem: string) {
    this.toastr.error(mensagem, 'Erro');
  }
}
