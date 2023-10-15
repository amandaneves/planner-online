import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarTarefaModalComponent } from './adicionar-tarefa-modal.component';

describe('AdicionarTarefaModalComponent', () => {
  let component: AdicionarTarefaModalComponent;
  let fixture: ComponentFixture<AdicionarTarefaModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdicionarTarefaModalComponent]
    });
    fixture = TestBed.createComponent(AdicionarTarefaModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
