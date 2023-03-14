import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { ExchangeRateDifference } from './exchangerate-difference';


@Component({
    selector: 'app-currency-table',
    templateUrl: './currencyrates.component.html',
    styleUrls: ['./currencyrates.component.css']

})

export class CurrencyTableComponent {
    currencyrates: ExchangeRateDifference[] | null = null;
    date: string = '';

    constructor(private http: HttpClient) { }

    onSubmit() {
        const url = `http://localhost:8080?date=${this.date}`;
        this.http.get<any[]>(url).pipe(
            map(data => data.map(rate => ({
                currency: rate.currency,
                rate: parseFloat(rate.rate),
                difference: parseFloat(rate.difference),
                quantity: rate.quantity
            })))
        ).subscribe((data: ExchangeRateDifference[]) => {
            this.currencyrates = data;
        });
    }
}
