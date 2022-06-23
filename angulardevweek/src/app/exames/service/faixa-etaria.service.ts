import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FaixaEtaria } from '../model/faixa-etaria';

@Injectable({
  providedIn: 'root'
})
export class FaixaEtariaService {

  constructor(private http: HttpClient) { }

  listFaixaEtaria(): Observable<FaixaEtaria[]> {
    const url = 'http://localhost:8080/faixaetaria';
    return this.http.get<FaixaEtaria[]>(url);
  }
}
