import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PartnerComponent } from './partner.component';

describe('PartnerComponent', () => {
  let component: PartnerComponent;
  let fixture: ComponentFixture<PartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PartnerComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
