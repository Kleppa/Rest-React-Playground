import {UPDATE_POKEDEX_STATE} from "../action/ActionTypes";

export default (state = [], action) =>{
    console.log("In reducer", action.type)

    switch (action.type) {
        case UPDATE_POKEDEX_STATE :
            console.log(state)
            return action.payload;

    }
    return state;
};