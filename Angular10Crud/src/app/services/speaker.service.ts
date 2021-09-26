import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Speaker } from "../models/speaker.model";

const baseUrl = 'http://localhost:8000/api/version1/speakers';

@Injectable({
  providedIn: 'root'
})
export class SpeakerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Speaker[]> {
    return this.http.get<Speaker[]>(baseUrl);
  }

  get(id: any): Observable<Speaker> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByName(title: any): Observable<Speaker[]> {
    return this.http.get<Speaker[]>(`${baseUrl}?title=${title}`);
  }
}
