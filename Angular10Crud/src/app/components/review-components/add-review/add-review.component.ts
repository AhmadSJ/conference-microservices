import { Component, OnInit } from '@angular/core';
import {Review} from "../../../models/review.model";
import {ReviewService} from "../../../services/review.service";

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {
  help: any;
  review: Review = {
    name: '',
    content: '',
    author: '',
    rating: '',
    sessionId: null,
    speakerId: null,
    sessionIdbool: true,
    Id: null,
  };
  submitted = false;

  constructor(private reviewService: ReviewService) { }

  ngOnInit(): void {
  }

  setSessionIdBool(): void {
    this.review.sessionIdbool = true;
  }

  setSessionIdBoolFalse(): void {
    this.review.sessionIdbool = false;
  }

  saveReview(): void {
    if (this.review.sessionIdbool){
      this.review.sessionId = this.review.Id;
    } else {
      this.review.speakerId = this.review.Id;
    }

    const data = {
      name: this.review.name,
      content: this.review.content,
      author: this.review.author,
      rating: this.review.rating,
      sessionId: this.review.sessionId,
      speakerId: this.review.speakerId
    };

    this.reviewService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newReview(): void {
    this.submitted = false;
    this.review = {
      name: '',
      content: '',
      author: '',
      rating: '',
      sessionId: null,
      speakerId: null,
      sessionIdbool: false,
      Id: null
    }
  }
}
