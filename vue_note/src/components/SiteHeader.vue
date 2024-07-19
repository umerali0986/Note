<template>

    <header>
        <h1>Tech Note</h1>
        <div class="searchBar-container" >
            <input type="text"  v-on:input="searchNote($event)"  placeholder="Search by title">
        </div>
    </header>

</template>

<script>
import NoteService from '@/services/NoteService';

export default {

    methods: {
        searchNote(event) {
            const searchedResult = this.$store.state.noteCollections.filter(
                function (note) {
                    return note?.title.toLowerCase().includes(event.target.value.toLowerCase());
                }
            );

            // if user add a search value
                if(event.target.value){
                    this.$store.commit('SET_NOTE_COLLECTIONS', searchedResult);
                }
                // if user didn't add a search value
                else{
                    NoteService.getAllNotes().then(response => {
      if(response.status === 200){
        this.$store.commit('SET_NOTE_COLLECTIONS', response.data);

      }
    })
                }
        }
    }
}
</script>

<style scoped>
.searchBar-container {
    display: flex;
    align-items: center;
    width: 400px;
}

@media (max-width:780px) {
    .searchBar-container{
        width: 200px;
    }
}

.searchBar-container input {
    padding: 7px;
    padding-left: 14px;
    margin-right: 10px;
    border-radius: 25px;
    width: 100%;
    color: white;
    background-color: rgb(3, 42, 81);
    box-shadow: -5px 5px 5px rgba(0, 0, 0, 0.3);
}

/* header{
        position: fixed;
        top: 0px;
        left: 0px;
        right: 0px;
        background-color: rgb(255, 255, 255);
        height: 60px;
        color: black;
        border-bottom: 1px solid rgb(216, 216, 216);
       z-index: 200px;
    } */

h1 {
    margin: 5px;
    margin-left: 18px;
    font-size: 30px;
    font-weight: bold;
}
</style>