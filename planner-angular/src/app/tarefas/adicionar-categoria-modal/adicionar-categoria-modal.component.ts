import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

import { CategoriasService } from '../services/categorias.service';

@Component({
  selector: 'app-adicionar-categoria-modal',
  templateUrl: './adicionar-categoria-modal.component.html',
  styleUrls: ['./adicionar-categoria-modal.component.scss']
})
export class AdicionarCategoriaModalComponent {

  form: FormGroup;
  erroDescricao: boolean;
  @Output() atualizarLista = new EventEmitter(false);

  constructor(
    private activeModalService: NgbActiveModal,
    private formBuilder: FormBuilder,
    private categoriasService: CategoriasService,
    private toastr: ToastrService
  ) {
    this.form = this.formBuilder.group({
      'descricao': [null]
    });
    this.erroDescricao = false;
  }

  closeModal() {
    this.form.reset();
    this.erroDescricao = false;
    this.activeModalService.close();
  }

  onSubmit() {
    if (!this.validarCategoria()) {
      return;
    }

    this.categoriasService.save(this.form.value)
      .subscribe(
        result => {
          this.onSuccess("Categoria adicionada com sucesso!");
        },
        error => {
          this.onError("Erro ao adicionar categoria.");
        }
      );
  }

  validarCategoria() {
    let camposValidados = true;
    this.erroDescricao = false;
    if (!this.form.value.descricao) {
      camposValidados = false;
      this.erroDescricao = true;
    }

    return camposValidados;
  }

  buscarCategorias() {
    this.atualizarLista.emit(true);
  }

  onSuccess(mensagem: string) {
    this.toastr.success(mensagem, 'Sucesso');
    this.buscarCategorias();
    this.closeModal();
  }

  onError(mensagem: string) {
    this.toastr.error(mensagem, 'Erro');
  }
}
