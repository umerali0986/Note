import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Note } from '../classes/note';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

   baseUrl = 'http://localhost:9000/note';

  constructor(private http : HttpClient) { }

  public getAllNotes() : Observable<Note[]>{

    return this.http.get<Note[]>(`${this.baseUrl}/all`);
  }

  public createNote(newNote : Note) : Observable<Note>{
    return this.http.post<Note>(`${this.baseUrl}`, newNote);
  }

  public getNoteById(id : number) : Observable<Note>{
    return this.http.get<Note>(`${this.baseUrl}/${id}`);
  }

  public updateNote(toBeUpdatedNote : Note) : Observable<Note>{
    return this.http.put<Note>(`${this.baseUrl}/${toBeUpdatedNote.id}`,toBeUpdatedNote);
  }

  public deleteNoteById(noteId : number): Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/${noteId}`);
  }

  public searchNoteByTitle(title : string): Observable<Note[]>{
    return this.http.get<Note[]>(`${this.baseUrl}/search?title=${title}`)
  }
}
