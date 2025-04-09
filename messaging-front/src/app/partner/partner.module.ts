import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { PartnerComponent } from './partner.component';
import { PageAddPartnerComponent } from './components/add-partner/page-add-partner.component';


const routes: Routes = [
    { path: '', component: PartnerComponent },
    { path: 'ajout-partenaire', component: PageAddPartnerComponent }
];

@NgModule({
    declarations: [
        PartnerComponent,
        PageAddPartnerComponent
    ],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        FormsModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatDialogModule,
        MatSelectModule
    ]
})
export class PartnerModule { }