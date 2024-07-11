import axios from 'axios';

const baseUrl = 'http://localhost:9000';
export default{

    getAllNotes(){
        return axios.get(baseUrl + '/note/all');
    },
    
    CreateNote(newNote){
        return axios.post(`${baseUrl}/note`,newNote);
    }


}