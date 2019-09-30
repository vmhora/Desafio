import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ContaComponent } from './conta/conta.component';
import { AppRoutingModule } from './app-routing.module';
import {ContaService} from './conta/conta.service';
import {HttpClientModule} from "@angular/common/http";
import { CurrencyMaskModule } from "ng2-currency-mask";

@NgModule({
  declarations: [
    AppComponent,
    ContaComponent
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CurrencyMaskModule
  ],
  providers: [ContaService],
  bootstrap: [AppComponent]
})
export class AppModule { }