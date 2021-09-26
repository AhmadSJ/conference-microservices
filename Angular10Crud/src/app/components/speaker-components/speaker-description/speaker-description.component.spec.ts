import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeakerDescriptionComponent } from './speaker-description.component';

describe('SpeakerDescriptionComponent', () => {
  let component: SpeakerDescriptionComponent;
  let fixture: ComponentFixture<SpeakerDescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpeakerDescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpeakerDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
