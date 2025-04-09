import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAddPartnerComponent } from './page-add-partner.component';

describe('ModalAddPartnerComponent', () => {
  let component: ModalAddPartnerComponent;
  let fixture: ComponentFixture<ModalAddPartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalAddPartnerComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ModalAddPartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
