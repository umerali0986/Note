import { Component, OnInit } from '@angular/core';
import { Note } from '../../classes/note';
import { NoteService } from '../../services/note.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-note',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-note.component.html',
  styleUrl: './edit-note.component.css'
})
export class EditNoteComponent implements OnInit {

  toBeUpdatedNote : Note = new Note();
  noteId : number;

  constructor(private noteService : NoteService, private router : Router,
             private route : ActivatedRoute){}
  
  ngOnInit(): void {

      this.getCurrentNote();
 
  }

  private getCurrentNote() : void{

   let  hasNoteId = this.route.snapshot.paramMap.has('id');

   if(hasNoteId){
    this.noteId = +this.route.snapshot.paramMap.get('id');

      this.noteService.getNoteById(this.noteId).subscribe(
      (response : Note) => {
        this.toBeUpdatedNote = response;
       
      }
      , 
      (error : HttpErrorResponse) => {
        alert('Error : '+ error.message);
      }
    )
   }
  }

  public updateNote() : void
{

  this.noteService.updateNote(this.toBeUpdatedNote).subscribe(
    (response : Note)=>{
      alert('Note updated successfully!')
      this.router.navigateByUrl('/home')
    },
    (error : HttpErrorResponse)=>{
      alert('Error: '+ error.message)
     
    }
  )
}
}
