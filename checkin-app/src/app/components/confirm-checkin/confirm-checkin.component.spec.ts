import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmCheckinComponent } from './confirm-checkin.component';

describe('ConfirmCheckinComponent', () => {
  let component: ConfirmCheckinComponent;
  let fixture: ComponentFixture<ConfirmCheckinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmCheckinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmCheckinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
