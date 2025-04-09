import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageComponent } from './message/message/message.component';
import { PartnerComponent } from './partner/partner.component';

const routes: Routes = [
    { path: '', component: MessageComponent },
    { path: 'messages', component: MessageComponent },
    { path: 'partenaires', loadChildren: () => import('./partner/partner.module').then(m => m.PartnerModule) },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }