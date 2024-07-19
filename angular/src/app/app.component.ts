import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { Note } from './classes/note';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  titles: string = '';
 
  isUserSearching = false; // check if user is searching for note in a search bar

  filteredNotes: Note[] = []; // store the filtered note after user search

  constructor(private router: Router, private homeComponent: HomeComponent) {}

  public handleHomePage(): void {
    this.router.navigateByUrl('/home');
  }

  public handleAddNotePage(): void {
    this.router.navigateByUrl('/create');
  }

  //handle search feature for note app
  public handleSearchingNote(): void {
    if(this.titles){
    this.router.navigateByUrl(`/home/search/${this.titles}`);
    }
    else{
    this.router.navigateByUrl(`/home`);
    }
  }
}
