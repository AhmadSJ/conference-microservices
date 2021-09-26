import { Component, OnInit } from '@angular/core';
import { SpeakerService } from "../../../services/speaker.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Speaker} from "../../../models/speaker.model";

@Component({
  selector: 'app-speaker-description',
  templateUrl: './speaker-description.component.html',
  styleUrls: ['./speaker-description.component.css']
})
export class SpeakerDescriptionComponent implements OnInit {

  currentSpeaker: Speaker = {
    first_name: '',
    last_name: '',
    specialization: '',
    bio: ''
  };
  message = '';

  constructor(
    private speakerService: SpeakerService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getSpeaker(this.route.snapshot.params.id);
  }

  getSpeaker(id: string): void {
    this.speakerService.get(id)
      .subscribe(
        data => {
          this.currentSpeaker = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateSpeaker(): void {
    this.message = '';

    this.speakerService.update(this.currentSpeaker.speaker_id, this.currentSpeaker)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This tutorial was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteSpeaker(): void {
    this.speakerService.delete(this.currentSpeaker.speaker_id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/speakers']);
        },
        error => {
          console.log(error);
        });
  }

}
