import { Component, OnInit } from '@angular/core';
import { FaixaEtaria } from '../model/faixa-etaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaEtariaService } from '../service/faixa-etaria.service';
import { OcorrenciaServiceService as OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-exames',
  templateUrl: './exames.component.html',
  styleUrls: ['./exames.component.css']
})
export class ExamesComponent implements OnInit {

  ocorrencia_exame: Ocorrencia[] = [];
  regioes: Regiao[] = [];
  faixa_etarias: FaixaEtaria[] = [];

  constructor(
    private ocorrenciaService: OcorrenciaService,
    private regioesService: RegiaoService,
    private faixaEtariaService: FaixaEtariaService
    
    ) { }

  ngOnInit(): void {
    this.regioesService.listRegioes().subscribe(regioes => {this.regioes = regioes});
    this.ocorrenciaService.listOcorrencias().subscribe(ocorrencias => {this.ocorrencia_exame = ocorrencias});
    this.faixaEtariaService.listFaixaEtaria().subscribe(faixaEtaria => {this.faixa_etarias = faixaEtaria});
  }

}
