<template>
  <div class="main-container ">
  <NoteCard v-for="note in $store.state.noteCollections" :key="note.id" :note="note"/>
</div>
</template>

<script>

import NoteService from '@/services/NoteService';
import NoteCard from '../components/NoteCard.vue';

export default {
  components: {
    NoteCard
  },
  computed:{

  
  },
  created(){
    NoteService.getAllNotes().then(response => {
      if(response.status === 200){
        this.$store.commit('SET_NOTE_COLLECTIONS', response.data);

      }
    }).catch(error => {
      console.error('Error: ',error)
    })

   

  },
  methods:{

  }
}
</script>

<style scoped>

.main-container {
  color: black;
  width: 100%;
  margin-top: 10px;
  margin-left: 15px;
  display: grid;
  grid-template-columns: 400px  400px 400px ;
  column-gap: 40px;
  row-gap: 40px;
}
</style>