<template>

    <div class="sidebars">

        <router-link to="/" style="text-decoration: none;">
            <div>
                <img src="../assets/homepage-icon.png" alt="home-page">
                <p>Home</p>
            </div>
        </router-link>

        <router-link to="/favorites">
            <div>
                <img src="../assets/star-24.png" alt="star">
                <p>Favorite</p>
            </div>
        </router-link>
        <router-link to="/create">
            <div>
                <img src="../assets/create-task-icon.png" alt="create-note">
                <p>Add Note</p>
            </div>
        </router-link>
        <!-- <Dialog>
            <DialogTrigger>
               
            </DialogTrigger>
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Edit profile</DialogTitle>
                    <DialogDescription>
                        Make changes to your profile here. Click save when you're done.
                    </DialogDescription>
                </DialogHeader>

                <DialogFooter>
                    Save changes
                </DialogFooter>
            </DialogContent>
        </Dialog> -->

    </div>


</template>

<script>
// import {
//   Dialog,
//   DialogContent,
//   DialogDescription, 
//   DialogFooter,
//   DialogHeader,
//   DialogTitle,
//   DialogTrigger,
// } from "@/components/ui/dialog";

export default {
    // components: {
    //     Dialog,
    //     DialogContent,
    //     DialogDescription,
    //     DialogFooter,
    //     DialogHeader,
    //     DialogTitle,
    //     DialogTrigger
    // }
}

</script>

<style scoped>
/* .sidebars{
    position: fixed;
    top: 60px;
    left: 0px;
    bottom: 0px;
    width: 180px;
    color: black;
   border-right:1px solid rgb(232, 232, 232) ;
} */

.sidebars div {
    display: flex;
    align-items: center;
    padding-left: 20px;
    height: 60px;
    font-size: 20px;
    margin-top: 10px;
    margin-bottom: 10px;
    color: black;

}

img {
    width: 30px;
    margin-right: 10px;
}
</style>