import { Component, OnInit } from '@angular/core';
import {Review} from "../../../models/review.model";
import {ReviewService} from "../../../services/review.service";

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {

  review?: Review;
  reviews?: Review[];
  currentReview: Review = {};
  currentIndex = -1;
  name = '';

  constructor(private reviewService: ReviewService) { }

  ngOnInit(): void {
    this.retrieveReviews();
  }

  retrieveReviews(): void {
    this.reviewService.getAll()
      .subscribe(
        data => {
          this.reviews = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveReviews();
    this.currentReview = {};
    this.currentIndex = -1;
  }

  setActiveReview(review: Review, index: number): void {
    this.currentReview = review;
    this.currentIndex = index;
  }

  removeAllReviews(): void {
    this.reviewService.deleteAll()
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
    this.currentReview = {};
    this.currentIndex = -1;

    this.reviewService.findByName(this.name)
      .subscribe(
        data => {
          this.reviews = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
