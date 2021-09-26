import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddSessionComponent } from './components/session-components/add-session/add-session.component';
import { SessionsListComponent } from './components/session-components/sessions-list/sessions-list.component';
import { SessionDescriptionComponent } from './components/session-components/session-description/session-description.component';
import { FooterComponent } from './layout/shared/footer/footer.component';
import { HeaderComponent } from './layout/shared/header/header.component';
import { SpeakerDescriptionComponent } from './components/speaker-components/speaker-description/speaker-description.component';
import { SpeakerListComponent } from './components/speaker-components/speaker-list/speaker-list.component';
import { AddSpeakerComponent} from "./components/speaker-components/add-speaker/add-speaker.component";
import { ReviewDescriptionComponent } from './components/review-components/review-description/review-description.component';
import { ReviewListComponent } from './components/review-components/review-list/review-list.component';
import { AddReviewComponent } from "./components/review-components/add-review/add-review.component";

@NgModule({
  declarations: [
    AppComponent,
    AddSessionComponent,
    SessionsListComponent,
    SessionDescriptionComponent,
    FooterComponent,
    HeaderComponent,
    SpeakerDescriptionComponent,
    SpeakerListComponent,
    AddSpeakerComponent,
    AddReviewComponent,
    ReviewDescriptionComponent,
    ReviewListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
