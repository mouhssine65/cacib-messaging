import { Component } from '@angular/core';
import { PartnerService } from '../../../core/services/partner.service';
import { Router } from '@angular/router';
import { Partner } from '../../../core/models/partner.interface';

@Component({
  selector: 'app-page-add-partner',
  standalone: false,
  templateUrl: './page-add-partner.component.html',
  styleUrl: './page-add-partner.component.css'
})
export class PageAddPartnerComponent {

  partner: Partner = {
    alias: '',
    type: '',
    direction: 'INBOUND',
    application: '',
    processedFlowType: 'MESSAGE',
    description: ''
  };

  constructor(
    private partnerService: PartnerService,
    private router: Router
  ) { }

  addPartner(): void {
    this.partnerService.addPartner(this.partner).subscribe(() => {
      this.router.navigate(['/partenaires']);
    });
  }

  cancel(): void {
    this.partner = {
      alias: '',
      type: '',
      direction: 'INBOUND',
      application: '',
      processedFlowType: 'MESSAGE',
      description: ''
    };
  }

}
