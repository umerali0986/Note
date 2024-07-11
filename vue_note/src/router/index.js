import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CreateNoteView from '../views/CreateNoteView'
import EditNoteview from '@/views/EditNoteview.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/create',
    name:'createNote',
    component: CreateNoteView
  },
  {
    path:'/edit/:id',
    name:'/edit',
    component: EditNoteview
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
