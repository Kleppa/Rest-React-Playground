import  axios from 'axios';
import { Observable } from 'rxjs';
import { combineEpics } from 'redux-observable';
import { combineReducers } from 'redux';


export const doStuff = (action$,store)=>{
    action$.ofType("REFRESH_POKEDEX")
        .switchMap(()=>{

        })
}
export const httpGetUrl = (url) => {

    const pokemons ="x";

    let observable = Observable.create( ( observer ) => {
        axios.get( url )
            .then( ( response ) => {
                observer.next( response.data );
            } )
            .catch( ( error ) => {
                observer.error( error );
            } );
    } );

    return observable;

};