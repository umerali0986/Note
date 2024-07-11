<template>
    
    <div class="main-container">
        <div class="container-note">
            <div class="note-title">
                <p>Title:</p>
                <input type="text" v-model="newNote.title" placeholder="Add title">
            </div>

            <div class="note">
                <h1>Add Note</h1>
                <textarea name="note" v-model="newNote.note" id="note"></textarea>
            </div>

            <div class="btn">
                <button type="submit" v-on:click.prevent="createNote()">Save</button>
            </div>

        </div>
    </div>
</template>

<script>
import NoteService from '@/services/NoteService';


export default {

    data(){
        return {
            newNote: {
                title : '',
                note : ''
            }
        }
    },
    methods:{
        createNote(){
            NoteService.CreateNote(this.newNote)
            .then(response => {
                if(response.status === 201){
                    this.$store.state.noteCollections.push(response.data);
                    console.log(this.$store.state.noteCollections);
                    alert('New note has been successfully added!');
                    this.$router.push('/');
                }
            }).catch(error => {
                console.error('Error: ', error);
            })
        }
    }

}

</script>

<style scoped>
.main-container {
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
}


.btn {
    display: flex;
    justify-content: end;
    font-size: 20px;
    margin-top: 10px;
}

.btn button {
    cursor: pointer;
    background-color: rgb(123, 203, 229);
    padding: 7px 25px;
    border-radius: 10px;
    font-weight: 400;
    transition: box-shadow 0.3s;
}

.btn button:hover {
    box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.3)
}

.container-note {
    height: 600px;
    width: 50%;
}

.note-title {
    width: 100%;
    display: block;
    height: auto;
    margin-bottom: 40px
}

.note-title input {
    width: 100%;
    height: 50px;
    padding: 7px;
    border-radius: 10px;
}

.note-title p {
    font-size: 20px;
    font-weight: bold;
}

.note {
    width: 100%;


}

.note h1 {
    font-weight: bold;
    font-size: 24px;
}

.note textarea {
    height: 400px;
    column-count: auto;
    width: 100%;
    padding: 7px;
    border-radius: 7px;
    margin-top: 10px;
    box-shadow: -1px -1px 5px rgba(0, 0,0, 0.3);
}
</style>
