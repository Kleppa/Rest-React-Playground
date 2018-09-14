import React, {Component} from 'react';
import * as httpWorker from '../utils/RestApiWorker.js'
import {Observable} from 'rxjs/Rx'
import {Pokemon} from "./Pokemon";
import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'
import {fetchPokemonFullfilled} from "../redux/action/GetEndpoint";
import {store} from "../redux/store";
import {GET_REQUEST} from "../redux/action/ActionTypes";


class PokemonGetter extends Component {
    state = {
        pokemons$: Observable.from(this.props.pokedex).map(pokemon =>
            <li key={pokemon.id}><Pokemon pokemon={pokemon}/></li>),
    };

    componentDidMount() {
        if (this.props.pokedex) {
            this.state.pokemons$.subscribe(pokemonListItem => {

            })
        }
    }

    pokemonList = (data) => {
        const listElementsOfPokemonComponents = data.map((pokemon) => {
            return <li><Pokemon pokemon={pokemon}/></li>
        });

        return <ul style={{listStyleType: "none"}}>{listElementsOfPokemonComponents}</ul>

    }


    render() {


        return (
            <div>
                <h3>{
                    this.props.pokedex ?
                        <ul style={{listStyleType: "none"}}> {this.pokemonList(this.props.pokedex)}
                        </ul> : "No Pokemons here"
                }</h3>
            </div>
        )
    }
}

const mapDispatchToState = (dispatch) => {
    dispatch({type: GET_REQUEST, payload: "http://localhost:8080/"})
    return {
        onRefreshPokedex: () => {
            dispatch({type: GET_REQUEST, payload: "http://localhost:8080/"})
        }
    }
};

function mapStateToProps(state) {

    return {pokedex: state.pokedex}

}

export default connect(mapStateToProps, mapDispatchToState)(PokemonGetter)