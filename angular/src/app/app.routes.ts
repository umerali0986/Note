import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AddNoteComponent } from './components/add-note/add-note.component';
import { EditNoteComponent } from './components/edit-note/edit-note.component';

export const routes: Routes = [
  {
    path: 'home/search/:keyword',
    component: HomeComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'create',
    component: AddNoteComponent,
  },

  {
    path: 'edit/:id',
    component: EditNoteComponent,
  },
];
