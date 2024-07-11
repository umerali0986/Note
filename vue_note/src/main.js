import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from './store'
import './assets/tailwind.css'

const store = createStore();

createApp(App).use(router).use(store).mount('#app')
