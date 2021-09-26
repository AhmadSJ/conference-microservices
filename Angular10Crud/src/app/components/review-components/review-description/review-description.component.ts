import { Component, OnInit } from '@angular/core';
import {Review} from "../../../models/review.model";
import {ReviewService} from "../../../services/review.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-review-description',
  templateUrl: './review-description.component.html',
  styleUrls: ['./review-description.component.css']
})
export class ReviewDescriptionComponent implements OnInit {

  currentReview: Review = {
    name: '',
    content: '',
    author: '',
    rating: ''
  };
  message = '';

  constructor(
    private reviewService: ReviewService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getReview(this.route.snapshot.params.id);
  }

  getReview(id: string): void {
    this.reviewService.get(id)
      .subscribe(
        data => {
          this.currentReview = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateReview(): void {
    this.message = '';

    this.reviewService.update(this.currentReview.review_id, this.currentReview)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This review was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteReview(): void {
    this.reviewService.delete(this.currentReview.review_id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/reviews']);
        },
        error => {
          console.log(error);
        });
  }
}
