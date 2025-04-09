import { HttpClient } from '@angular/common/http';
import { Component, OnInit, signal } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Message } from '../../core/models/message.interface';
import { MessageService } from '../../core/services/message.service';
import { MatDialog } from '@angular/material/dialog';
import { MessageDetailComponent } from '../components/message-detail/message-detail.component';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-message',
  standalone: true,
  imports: [MatTableModule, CommonModule],
  templateUrl: './message.component.html',
  styleUrl: './message.component.css'
})
export class MessageComponent implements OnInit {
  displayedColumns: string[] = ['id', 'content'];
  dataSource = new MatTableDataSource<Message>();

  constructor(private messageService: MessageService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.fetchMessages();
  }

  fetchMessages() {
    this.messageService.getAllMessage().subscribe({
      next: (data) => {
        this.dataSource.data = data;
      },
      error: (error) => {
        console.error('Error fetching messages:', error);
      }
    });
  }

  openDialog(message: any): void {
    this.dialog.open(MessageDetailComponent, {
      data: message
    });
  }
}