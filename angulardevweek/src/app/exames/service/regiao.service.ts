import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Regiao } from "../model/regiao";


@Injectable({
    providedIn: 'root'
})
export class RegiaoService {

    constructor(private http: HttpClient) {

    }

    listRegioes(): Observable<Regiao[]> {
        const url = 'http://localhost:8080/regiao';
        return this.http.get<Regiao[]>(url);
    }
    
}