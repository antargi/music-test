import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { MusicGenre } from '../models/MusicGenre';
import { Observable } from 'rxjs';
import { Preference } from '../models/Preference';

@Injectable({
  providedIn: 'root'
})
export class MusicFormService {

  private endpoint = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  getMusicGenres(): Observable<MusicGenre[]> {
    return this.http.get<MusicGenre[]>(this.endpoint+'/musicGenres');
  }

  saveMusicPreference(preference: Preference) {
    return this.http.post(this.endpoint+'/emailUser', preference);
  }
}
