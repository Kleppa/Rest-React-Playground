import React, {Component} from 'react';

import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';

import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';

import Typography from '@material-ui/core/Typography';

export class Pokemon extends Component{
    constructor(){
        super();
        console.log("Hello")

    }
    render() {
        console.log("Prop",this.props);
        const { classes } = {
            card: {
                maxWidth: 345,
            },
            media: {
                height: 140,
            },
        };

        return (
            <li key ={this.props.pokemon.id}>
          <p>{this.props.pokemon.name}</p>
            </li>
        );
    }


    }