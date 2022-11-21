import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NovaReservaComponent } from './novareserva.component';

describe('NovaReservaComponent', () => {
  let component: NovaReservaComponent;
  let fixture: ComponentFixture<NovaReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NovaReservaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NovaReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
