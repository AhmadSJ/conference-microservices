import { Component, OnInit } from '@angular/core';
import {Speaker} from "../../../models/speaker.model";
import {SpeakerService} from "../../../services/speaker.service";

@Component({
  selector: 'app-speaker-list',
  templateUrl: './speaker-list.component.html',
  styleUrls: ['./speaker-list.component.css']
})
export class SpeakerListComponent implements OnInit {

  speaker?: Speaker;
  speakers?: Speaker[];
  currentSpeaker: Speaker = {};
  currentIndex = -1;
  name = '';

  constructor(private speakerService: SpeakerService) { }

  ngOnInit(): void {
    this.retrieveSpeakers();
  }

  retrieveSpeakers(): void {
    this.speakerService.getAll()
      .subscribe(
        data => {
          this.speakers = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveSpeakers();
    this.currentSpeaker = {};
    this.currentIndex = -1;
  }

  setActiveSpeaker(speaker: Speaker, index: number): void {
    this.currentSpeaker = speaker;
    this.currentIndex = index;
  }

  removeAllSpeakers(): void {
    this.speakerService.deleteAll()
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
    this.currentSpeaker = {};
    this.currentIndex = -1;

    this.speakerService.findByName(this.name)
      .subscribe(
        data => {
          this.speakers = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
