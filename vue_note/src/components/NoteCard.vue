<template>
    <div class="note-container">
        <p><span style="font-weight: bold">Title: </span>{{ note.title }}</p>
        <div class="btn-container">
     <router-link :to="`/edit/${note.id}`">
       <button class="edit-btn">Edit</button>
     </router-link>
      <button class="delete-btn">Delete</button>
    </div>
    </div>
    

</template>

<script>

export default {
  props:['note']
}


</script>


<style scoped>
.note-container{  
  display: flex;
  flex-direction: column;
  width: 250px;
  height: 95px;
  background-color: white;
  padding-top: 15px;
  padding-left: 15px;

}

.btn-container{
  display: flex;
  font-weight: 400;
  padding: 5px;
  padding-top: 15px;
  width: 100%;
  justify-content: end;
  font-size: 14px;
}

.delete-btn , .edit-btn{
  color: rgb(186, 54, 54);
  background-color:rgb(34, 41, 64);
  padding: 5px;
  border-radius: 5px;
  cursor: pointer
}
.edit-btn{
color: white;
padding: 5px 7px;
margin-right: 15px;
}
</style>