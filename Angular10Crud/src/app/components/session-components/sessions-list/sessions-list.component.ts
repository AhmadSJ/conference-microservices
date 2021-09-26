import { Component, OnInit } from '@angular/core';
import { Session} from "../../../models/session.model";
import {SessionService} from "../../../services/session.service";

@Component({
  selector: 'app-sessions-list',
  templateUrl: './sessions-list.component.html',
  styleUrls: ['./sessions-list.component.css']
})
export class SessionsListComponent implements OnInit {
  session?: Session;
  sessions?: Session[];
  currentSession: Session = {};
  currentIndex = -1;
  name = '';

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
    this.retrieveSessions();
  }

  retrieveSessions(): void {
    this.sessionService.getAll()
      .subscribe(
        data => {
          this.sessions = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveSessions();
    this.currentSession = {};
    this.currentIndex = -1;
  }

  setActiveSession(session: Session, index: number): void {
    this.currentSession = session;
    this.currentIndex = index;
  }

  removeAllSessions(): void {
    this.sessionService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }

  searchName(): void {
    this.currentSession = {};
    this.currentIndex = -1;

    this.sessionService.findByName(this.name)
      .subscribe(
        data => {
          this.sessions = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
