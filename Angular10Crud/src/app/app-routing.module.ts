import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SessionsListComponent } from './components/session-components/sessions-list/sessions-list.component';
import { SessionDescriptionComponent } from './components/session-components/session-description/session-description.component';
import { AddSessionComponent } from './components/session-components/add-session/add-session.component';
import { AddSpeakerComponent } from "./components/speaker-components/add-speaker/add-speaker.component";
import { SpeakerListComponent} from "./components/speaker-components/speaker-list/speaker-list.component";
import { SpeakerDescriptionComponent } from "./components/speaker-components/speaker-description/speaker-description.component";
import {ReviewDescriptionComponent} from "./components/review-components/review-description/review-description.component";
import {AddReviewComponent} from "./components/review-components/add-review/add-review.component";
import {ReviewListComponent} from "./components/review-components/review-list/review-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'sessions', pathMatch: 'full'},
  { path: 'sessions', component: SessionsListComponent },
  { path: 'sessions/:id', component: SessionDescriptionComponent },
  { path: 'add_session', component: AddSessionComponent },
  { path: 'add_speaker', component: AddSpeakerComponent },
  { path: 'speakers', component: SpeakerListComponent },
  { path: 'speakers/:id', component: SpeakerDescriptionComponent },
  { path: 'reviews', component: ReviewListComponent },
  { path: 'reviews/:id', component: ReviewDescriptionComponent },
  { path: 'add_review', component: AddReviewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
