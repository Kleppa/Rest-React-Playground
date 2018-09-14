

import {UPDATE_POKEDEX_STATE} from "./ActionTypes";

export function fetchPokemonFullfilled(pokemons) {
    return {
        type: UPDATE_POKEDEX_STATE,
        payload:pokemons
    }
}