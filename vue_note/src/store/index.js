import { createStore as _createStore } from 'vuex';

export function createStore(){

    let store = _createStore({
        state: {
            noteCollections: []
        },
        mutations: {

            SET_NOTE_COLLECTIONS(state, notes){
                state.noteCollections = notes;
            }
        }


    });

    return store;
}