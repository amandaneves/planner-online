import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarCategoriaModalComponent } from './adicionar-categoria-modal.component';

describe('AdicionarCategoriaModalComponent', () => {
  let component: AdicionarCategoriaModalComponent;
  let fixture: ComponentFixture<AdicionarCategoriaModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdicionarCategoriaModalComponent]
    });
    fixture = TestBed.createComponent(AdicionarCategoriaModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
