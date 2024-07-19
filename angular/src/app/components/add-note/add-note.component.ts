import { Component } from '@angular/core';
import { Note } from '../../classes/note';
import { NoteService } from '../../services/note.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-note',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-note.component.html',
  styleUrl: './add-note.component.css'
})
export class AddNoteComponent {

  newNote : Note = new Note();

  constructor(private noteService : NoteService, private router : Router){}

  public createNote() : void{
  this.noteService.createNote(this.newNote).subscribe(
    (response : Note) => {
      alert('Note has been created successfully!');
      this.router.navigateByUrl('/home');
    },
    (error : HttpErrorResponse)=>{
      alert('Error :' + error.message);
    }
  )
  }
}
