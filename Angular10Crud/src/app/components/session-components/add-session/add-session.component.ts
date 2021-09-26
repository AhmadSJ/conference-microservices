import { Component, OnInit } from '@angular/core';
import {Session} from "../../../models/session.model";
import { SessionService} from "../../../services/session.service";

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  session: Session = {
    name: '',
    description: '',
    subject: '',
    address: '',
    start_date_time: '',
    end_date_time: '',
    max_participants: ''
  };
  submitted = false;

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  saveSession(): void {
    const data = {
      name: this.session.name,
      description: this.session.description,
      subject: this.session.subject,
      address: this.session.address,
      start_date_time: this.session.start_date_time,
      end_date_time: this.session.end_date_time,
      max_participants: this.session.max_participants
    };

    this.sessionService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newSession(): void {
    this.submitted = false;
    this.session = {
      name: '',
      description: '',
      subject: '',
      address: '',
      start_date_time: '',
      end_date_time: '',
      max_participants: ''
    }
  }

}
