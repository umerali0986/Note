<template>
    <div class="main-container ">
        <NoteCard v-for="note in favoriteNotes" :key="note.id" :note="note" />
    </div>
</template>

<script>
import NoteCard from '../components/NoteCard.vue';

export default {
    components:{
        NoteCard
    },
    data() {
        return {
            favoriteNotes: null
        }
    },
    created() {
        this.favoriteNotes = this.$store.state.noteCollections.
            filter(function (note) {
                return note.favorite === true
            });

        console.log(this.favoriteNotes);
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
    grid-template-columns: 400px 400px 400px;
    column-gap: 40px;
    row-gap: 40px;
}
</style>