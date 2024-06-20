import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { AlimentosService } from './alimentos.service';
import { Observable } from 'rxjs';
import { AlimentoDto } from './model';
import { AsyncPipe } from '@angular/common';

@Component({
    selector     : 'alimentos',
    standalone   : true,
    templateUrl  : './alimentos.component.html',
    encapsulation: ViewEncapsulation.None,
    imports: [MatSidenavModule, AsyncPipe]
})
export class AlimentosComponent implements OnInit {
    
    public alimentos$: Observable<AlimentoDto[]>;

    constructor(private alimentosService: AlimentosService) {
    }

    ngOnInit(): void {
        this.alimentos$ = this.alimentosService.getAlimentos();
    }

}
