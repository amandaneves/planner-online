import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

import { TarefasService } from '../services/tarefas.service';

@Component({
  selector: 'app-adicionar-tarefa-modal',
  templateUrl: './adicionar-tarefa-modal.component.html',
  styleUrls: ['./adicionar-tarefa-modal.component.scss']
})
export class AdicionarTarefaModalComponent implements OnInit {

  // @Input() idModal?: string;
  form: FormGroup;
  @Output() atualizarLista = new EventEmitter(false);

  constructor(
    private activeModalService: NgbActiveModal,
    private formBuilder: FormBuilder,
    private tarefasService: TarefasService,
    private toastr: ToastrService
  ) {
    this.form = this.formBuilder.group({
      'descricao': [null]
    });
  }

  ngOnInit(): void {
  }

  closeModal() {
    this.form.reset();
    this.activeModalService.close();
  }

  onSubmit() {
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
