import { Component, OnInit } from '@angular/core';
import { NoteService } from '../../services/note.service';
import { Note } from '../../classes/note';
import { not } from 'rxjs/internal/util/not';
import { HttpErrorResponse } from '@angular/common/http';
import { NgFor } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgFor],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  notes: Note[]=[];

  constructor(private noteService: NoteService, private activeRoute : ActivatedRoute,
               private router: Router) {}

  ngOnInit(): void {
    let isUserSearching = this.activeRoute.snapshot.paramMap.has("keyword");

    if(isUserSearching){
      this.handleSearchingNote();
    }
    else{
      this.getAllNotes();
    }
    
  }

  public getAllNotes(): void {
    this.noteService.getAllNotes().subscribe(
      (response: Note[]) => {
        this.notes = response;
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  
  }

  // used to handle search for note by title
  public handleSearchingNote() : void{
    const searchKeyword = this.activeRoute.snapshot.paramMap.get("keyword");
    this.noteService.searchNoteByTitle(searchKeyword).subscribe(
      (response : Note[])=>{
        this.notes = response;
      },
      (error : HttpErrorResponse)=>{
        console.log('Error: '+ error.message)
      }
    )
  }

  //navigate user to edit page
  public handleEditNotePage(noteId: number): void {
    this.router.navigateByUrl(`/edit/${noteId}`);
  }

  // used to handle deleting a note
  public handleDeleteNote(noteId: number, title: string): void {
    let hasUserConfirmed = confirm(
      'Are you sure you want to delete note with title: ' + title
    );

    if (hasUserConfirmed) {
      this.noteService.deleteNoteById(noteId).subscribe(
        (response: void) => {
          alert('Note has been deleted successfully!');
          this.getAllNotes();
        },
        (error: HttpErrorResponse) => {
          alert('Error: ' + error.message);
        }
      );
    }
  }
}
