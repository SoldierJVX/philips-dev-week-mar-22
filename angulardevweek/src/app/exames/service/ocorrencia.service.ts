import { Injectable } from '@angular/core';
import { Ocorrencia } from '../model/ocorrencia';

@Injectable({
  providedIn: 'root'
})
export class OcorrenciaServiceService {

  constructor() { }

  listOcorrencias(): Ocorrencia[] {
    return [
        {
            id: 1,
            regiao_id: 2,
            mes: 5,
            faixa_id: 1,
            qtd_exames: 1564
        }
    ];
}
}
