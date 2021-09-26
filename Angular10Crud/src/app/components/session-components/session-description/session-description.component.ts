import { Component, OnInit } from '@angular/core';
import { SessionService } from "../../../services/session.service";
import { ActivatedRoute, Router } from '@angular/router';
import { Session } from "../../../models/session.model";

@Component({
  selector: 'app-session-description',
  templateUrl: './session-description.component.html',
  styleUrls: ['./session-description.component.css']
})
export class SessionDescriptionComponent implements OnInit {

  currentSession: Session = {
    name: '',
    description: ''
  };
  message = '';

  constructor(
    private sessionService: SessionService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getSession(this.route.snapshot.params.id);
  }

  getSession(id: string): void {
    this.sessionService.get(id)
      .subscribe(
        data => {
          this.currentSession = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateSession(): void {
    this.message = '';

    this.sessionService.update(this.currentSession.session_id, this.currentSession)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This tutorial was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteSession(): void {
    this.sessionService.delete(this.currentSession.session_id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/sessions']);
        },
        error => {
          console.log(error);
        });
  }

}
