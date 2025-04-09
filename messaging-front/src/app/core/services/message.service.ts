import { Injectable } from '@angular/core';
import { Message } from '../models/message.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private apiUrl = 'http://localhost:8080/api/messages';

  constructor(private http: HttpClient) { }

  getAllMessage(): Observable<Message[]> {
    return this.http.get<Message[]>(this.apiUrl);
  }
}
