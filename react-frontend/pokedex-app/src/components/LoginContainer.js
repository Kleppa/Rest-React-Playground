import React, {Component} from 'react'
import axios from 'axios'
import {GET_REQUEST} from "../redux/action/ActionTypes";
import {connect} from "react-redux";

class LoginContainer extends Component {
    constructor() {
        super();


        this.state = {username: "", password: ""};
        this.updateUserState = (username)=>{this.props.updateUserState( username)};
        this.submitUser = this.submitUser.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    render() {
        return (
            <div>
                <form>
                    <input id="username" type="text" onChange={this.handleChange} value={this.state.username}/>
                    <input id="password" type="password" onChange={this.handleChange} value={this.state.password}/>
                    <input type="submit" value="sign up"
                           onClick={() => this.submitUser(this.state.username, this.state.password)}/>
                    <input type="submit" value="sign in"
                           onClick={() => this.login(this.state.username, this.state.password)}/>
                </form>
            </div>
        )
    }

    handleChange(event) {
        const propname = event.target.id;
        console.log("State", this.state);
        if (propname === "password") {
            this.setState({password: event.target.value})
        } else {
            this.setState({username: event.target.value})
        }

    }

    submitUser(username, password) {
        axios.post("http://localhost:8080/create/user", {username, password}).then(() => {
            this.setState({userCreated: true});
            this.login(username, password);

        }).catch(x => console.error(x))
    }

    login(username, password) {
//,{   headers: {Authorization:Math.random().toString(36).substr(2).toString()}
        console.log("LOGGING IN ");
        axios.post("http://localhost:8080/login",{username,password } ).then((e)=>{
            console.log("Response ", e)
        })
        this.updateUserState(username);

    }

}

const mapDispatchToState = (dispatch) => {
    //  dispatch({type: GET_REQUEST, payload: "http://localhost:8080/"})
    return {
        updateUserState: (username) => {
            console.log("Updating userstateus",username)
            return dispatch({type:"UPDATE_USER_STATE", payload:{username}})
        }
    }
};

function mapStateToProps(state) {
    console.log("State in login container", state);
    return {
        pokedex: state.pokedex,
        user:state.user,

    }

}

export default connect(mapStateToProps, mapDispatchToState)(LoginContainer)