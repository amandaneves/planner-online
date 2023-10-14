import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefasModalAdicionarComponent } from './tarefas-modal-adicionar.component';

describe('TarefasModalAdicionarComponent', () => {
  let component: TarefasModalAdicionarComponent;
  let fixture: ComponentFixture<TarefasModalAdicionarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TarefasModalAdicionarComponent]
    });
    fixture = TestBed.createComponent(TarefasModalAdicionarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
