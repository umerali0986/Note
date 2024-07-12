<template>

    <header>
        <h1>Tech Note</h1>
        <div class="searchBar-container">
            <input type="text" v-on:change="searchNote()" v-model="title" placeholder="Search by title">
        </div>
    </header>

</template>

<script>
export default {

    data() {
        return {

            title: ''

        }
    },

    methods: {
        searchNote() {
            const searchedResult = this.$store.state.noteCollections.filter(
                function (note) {
                    // console.log(this.title);
                    return note.title !== "";
                    // return note.includes(this.title);
                }
            );


            this.$store.commit('SET_NOTE_COLLECTIONS', searchedResult);
        }
    }
}
</script>

<style scoped>
.searchBar-container {
    display: flex;
    align-items: center;
}

.searchBar-container input {
    padding: 7px;
    padding-left: 14px;
    margin-right: 10px;
    border-radius: 25px;
    width: 400px;
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