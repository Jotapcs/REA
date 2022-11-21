import { TestBed } from '@angular/core/testing';

import { DadosDaReservaService } from './dadosdareserva.service';

describe('DadosDaReservaService', () => {
  let service: DadosDaReservaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DadosDaReservaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
