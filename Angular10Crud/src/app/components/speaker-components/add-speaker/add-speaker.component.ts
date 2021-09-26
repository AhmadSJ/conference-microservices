import { Component, OnInit } from '@angular/core';
import { Speaker} from "../../../models/speaker.model";
import { SpeakerService } from "../../../services/speaker.service";

@Component({
  selector: 'app-add-speaker',
  templateUrl: './add-speaker.component.html',
  styleUrls: ['./add-speaker.component.css']
})
export class AddSpeakerComponent implements OnInit {

  speaker: Speaker = {
    first_name: '',
    last_name: '',
    specialization: '',
    bio: ''
  };
  submitted = false;

  constructor(private speakerService: SpeakerService) { }

  ngOnInit(): void {
  }

  saveSpeaker(): void {
    const data = {
      first_name: this.speaker.first_name,
      last_name: this.speaker.last_name,
      specialization: this.speaker.specialization,
      bio: this.speaker.bio
    };

    this.speakerService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newSpeaker(): void {
    this.submitted = false;
    this.speaker = {
      first_name: '',
      last_name: '',
      specialization: '',
      bio: ''
    }
  }
}
