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
    dateError: boolean | false = false;

    constructor(private http: HttpClient) { }

    onSubmit() {

        if (this.date == '' || this.dateError == true) return;

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

    validateDate() {
        const minDate = new Date("1993-06-29");
        const maxDate = new Date("2014-12-31");
        const inputDate = new Date(this.date);
        this.dateError = inputDate < minDate || inputDate > maxDate;
    }
}
