import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { MusicFormService } from './music-form.service';
import { Observable } from 'rxjs';
import { Preference } from '../models/Preference';

describe('MusicFormService', () => {
  let service: MusicFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(MusicFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  const example : Preference = {
    useremail: {
        email:"example4@gmail.com"
    },
    musicPreferences: [
        { id: "1", name:"rock"},
        { id: "3", name:"pop"}
    ]
  }

  it('should be false because already exists email', () => {
    (done: DoneFn) => {
      service.saveMusicPreference(example).subscribe(value => {
        expect(value).toBe(false);
        done(); });
    }});

});
