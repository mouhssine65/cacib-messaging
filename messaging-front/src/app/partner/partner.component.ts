
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { PartnerService } from '../core/services/partner.service';
import { DeleteConfirmationComponent } from './components/delete-confirmation/delete-confirmation.component';
import { Router } from '@angular/router';
import { Partner } from '../core/models/partner.interface';



@Component({
  selector: 'app-partenaire',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.css']
})
export class PartnerComponent implements OnInit {
  displayedColumns: string[] = ['alias', 'type', 'direction', 'application', 'processedFlowType', 'description', 'actions'];
  dataSource = new MatTableDataSource<Partner>();

  constructor(private partnerService: PartnerService, private dialog: MatDialog, private router: Router) { }
  ngOnInit(): void {
    this.fetchPartenaires();
  }

  fetchPartenaires(): void {
    this.partnerService.getPartners().subscribe(partners => {
      this.dataSource.data = partners;
    });
  }

  openAddPartner(): void {
    this.router.navigate(['/ajout-partenaire']);
  }

  confirmDelete(id: string): void {
    const dialogRef = this.dialog.open(DeleteConfirmationComponent);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.partnerService.deletePartner(id).subscribe(() => {
          this.dataSource.data = this.dataSource.data.filter(p => p.id !== id);
        });
      }
    });
  }

  deletePartenaire(id: string) {
    this.dataSource.data = this.dataSource.data.filter(p => p.id !== id);
    // You can also send a DELETE request to the backend to remove the partenaire
  }
}