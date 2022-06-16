import { TestBed } from '@angular/core/testing';

import { OcorrenciaServiceService } from './ocorrencia.service';

describe('OcorrenciaServiceService', () => {
  let service: OcorrenciaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OcorrenciaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
