import React, {Component} from 'react';

import './App.css';
import {CustomHeader} from "./components/CustomHeader";
import PokemonGetter from "./components/PokemonGetter";
import {pullEpic} from "./redux/epic/pullerEpic";
import {combineEpics} from 'redux-observable';
import {Provider} from 'react-redux'
import {createEpicMiddleware} from "redux-observable";

import {createStore, applyMiddleware} from 'redux'
import LoginContainer from './components/LoginContainer.js'
import reducers from "./redux/reducer/combinedReducers.js";
import {GET_REQUEST, UPDATE_POKEDEX_STATE} from "./redux/action/ActionTypes";
import { createLogger } from 'redux-logger';
const epicCombined = combineEpics(pullEpic);
const middleware = createEpicMiddleware();
const store = createStore(
    reducers,
    applyMiddleware(middleware,createLogger())
);
middleware.run(epicCombined);

class App extends Component {
    render() {

        return (
            <Provider store={store}>
                <div className="App">
                    <CustomHeader/>
                    <div className="content-container">
                        <PokemonGetter/>
                        <LoginContainer/>
                    </div>
                </div>
            </Provider>
        );

    }
}

export default App;
