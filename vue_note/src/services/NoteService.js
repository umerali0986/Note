import axios from 'axios';

const baseUrl = 'http://localhost:9000';
export default{

    getAllNotes(){
        return axios.get(baseUrl + '/note/all');
    },
    
    CreateNote(newNote){
        return axios.post(`${baseUrl}/note`,newNote);
    },

    getNoteById(id){
        return axios.get(`${baseUrl}/note/${id}`);
    },

    editNote(id, note){
        return axios.put(`${baseUrl}/note/${id}`,note);
    }


}