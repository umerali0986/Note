<template >

  <body>
    <header>
      <SiteHeader />
    </header>

    <div class="container">

      <div class="sidebar-container">
        <SideBar />
        
      </div>


        <router-view/>
        <!-- <router-view/> -->
        <!-- <div class="note-container">
          <p><span style="font-weight: bold">Title: </span>First note</p>
        </div>

        <div class="note-container">
          <p><span style="font-weight: bold">Title: </span>First note</p>
        </div>

        <div class="note-container">
          <p><span style="font-weight: bold">Title: </span>First note</p>
        </div>

        <div class="note-container">
          <p><span style="font-weight: bold">Title: </span>First note</p>
        </div>

        <div class="note-container">
          <p><span style="font-weight: bold">Title: </span>First note</p>
        </div> -->
       

    
    </div>
  </body>

</template>


<script>
import SideBar from './components/SideBar.vue';
import SiteHeader from './components/SiteHeader.vue';

export default {

  components: {
    SideBar,
    SiteHeader
  }
}
</script>

<style scoped>

body {
  background-color: rgb(234, 234, 234);
  position: relative;
  height: auto;
  width: auto;
  padding-left: 180px;
  padding-top: 70px;
  font-family: Arial;
  
}



p{
  margin: 0px;
  
}

header{
        display: flex;
        justify-content: space-between;
        position: fixed;
        top: 0px;
        left: 0px;
        right: 0px;
        background-color: rgb(255, 255, 255);
        height: 60px;
        color: black;
        border-bottom: 1px solid rgb(216, 216, 216);
       z-index: 200px;
    }
    
.container {
  display: flex;
  height: auto;
  width: 100%;
  /* height: 100% !important; */
  /* width: 100%; */
  left: 0;
  right: 0;
  bottom: 0;
  

}



/* .note-container{
  width: 250px;
  height: 65px;
  background-color: white;
  padding-top: 15px;
  padding-left: 15px;
  cursor: pointer;
} */


.sidebar-container {
  background-color: rgb(255, 255, 255);
  position: fixed;
  top: 60px;
  left: 0px;
  bottom: 0px;
  width: 180px;
  color: black;
  border-top: 1px solid rgb(216, 216, 216);
  border-right: 1px solid rgb(232, 232, 232);
}
</style>
