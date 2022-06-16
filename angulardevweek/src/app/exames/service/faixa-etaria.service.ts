import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FaixaEtariaService {

  constructor() { }

  listFaixaEtaria(): import("../model/faixa-etaria").FaixaEtaria[] {
    throw new Error('Method not implemented.');
  }
}
