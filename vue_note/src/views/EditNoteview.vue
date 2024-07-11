<template>
    <div class="main-container">
        <div class="container-note">
            <div class="note-title">
                <p>Title:</p>
                <input type="text" v-model="currentNote.title">
            </div>

            <div class="note">
                <h1>Edit Note:</h1>
                <textarea name="note" id="note" v-model="currentNote.note"></textarea>
            </div>

            <div class="btn">
                <button type="submit" v-on:click.prevent="editNote()">Save</button>
            </div>

        </div>
    </div>
</template>

<script>
import NoteService from '@/services/NoteService';

export default {

    data() {
        return {
            currentNote: {}
            
        }
    },
    methods: {
        getCurrentNoteById(id) {
            NoteService.getNoteById(id).then(response => {
                if (response.status === 200) {
                    this.currentNote = response.data;
                    console.log(this.currentNote);
                }
            }).
                catch(error => {
                    console.error('Error: ', error);
                })
        },
        editNote(){
            console.log('clicked')
            NoteService.editNote(this.$route.params.id,this.currentNote)
            .then(response => {
                if(response.status === 200){
                    alert("The Note has been updated successfully!");
                    this.$router.push('/');
                }
            }).catch(error => {
                console.error('Error: ', error);
            })
        }

    },

    created() {
        const noteId = this.$route.params.id;
        this.getCurrentNoteById(noteId);
    
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
    box-shadow: -1px -1px 5px rgba(0, 0, 0, 0.3);
}
</style>