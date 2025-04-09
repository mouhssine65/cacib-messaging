import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { MessageComponent } from "./message/message/message.component";
import { PartnerModule } from './partner/partner.module';

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MatTableModule,
        MatToolbarModule,
        MatMenuModule, MatTableModule,
        MatButtonModule,
        HttpClientModule,
        AppRoutingModule,
        MessageComponent,
        PartnerModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }