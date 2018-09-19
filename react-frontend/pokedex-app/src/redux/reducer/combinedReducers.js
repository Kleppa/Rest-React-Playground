import {combineReducers} from 'redux'
import pokedexReducer from "./pokedexReducer";

import UserReducer from "./UserReducer";

export default combineReducers({
    pokedex: pokedexReducer,
    user:UserReducer
});