import { HttpClient } from "@angular/common/http";
import { ChangeDetectorRef, Injectable, NgZone } from "@angular/core";
import { BehaviorSubject, Observable, tap } from "rxjs";
import { AlimentoDto } from "./model";
import _ from "lodash";

@Injectable({providedIn: 'root'})
export class AlimentosService {

    private alimentos: AlimentoDto[];

    private alimentosSubject: BehaviorSubject<AlimentoDto[]>;

    private eventSource: EventSource;

    constructor(private httpClient: HttpClient, private zone: NgZone) {

    }

    getAlimentos(): Observable<AlimentoDto[]> {
        if (!this.alimentosSubject) {
            this.alimentosSubject = new BehaviorSubject<AlimentoDto[]>(null);
            this.httpClient.get<AlimentoDto[]>('http://localhost:8080/api/alimentos').subscribe((alimentos) => {
                this.alimentos = alimentos;
                this.alimentosSubject.next(this.alimentos);
            });
            this.eventSource = new EventSource('http://localhost:8080/api/alimentos/sse');
            this.registrarCriado();
            this.registrarExcluido();
        }
        return this.alimentosSubject.asObservable();
    }

    private registrarCriado(): void {
        this.eventSource.addEventListener('criado', (event) => {
            console.log(event);
            let alimento: AlimentoDto = JSON.parse(event.data);
            let index = _.findIndex(this.alimentos, (a) => a.id == alimento.id);
            if (index == -1) {
                this.alimentos.push(alimento);
                this.zone.run(() => {
                    this.alimentosSubject.next(this.alimentos);
                });
            }
        });
    }

    private registrarExcluido(): void {
        this.eventSource.addEventListener('excluido', (event) => {
            console.log(event);
            let id: string = JSON.parse(event.data);
            let index = _.findIndex(this.alimentos, (a) => a.id == id);
            if (index != -1) {
                this.alimentos.splice(index, 1);
                this.zone.run(() => {
                    this.alimentosSubject.next(this.alimentos);
                });
            }
        });
    }

}