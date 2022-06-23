import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Ocorrencia } from '../model/ocorrencia';

@Injectable({
  providedIn: 'root'
})
export class OcorrenciaServiceService {

  constructor(private http: HttpClient) { }

  listOcorrencias(): Observable<Ocorrencia[]> {
    const url = 'http://localhost:8080/incidencia';
        return this.http.get<Ocorrencia[]>(url);
}
}
