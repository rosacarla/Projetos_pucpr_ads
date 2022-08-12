"use strict";

//Projeto: calculadora-app
//Codigo: botao da calculadora
//Autora: Carla Edila Silveira
//Finalidade: componente para entrada de dados

import React, {Component} from 'react';
import "./Botao.css";
 
class BotaoC extends Component {
    render(){
        return(
            <div 
                className="BotaoC"
                onClick={this.props.onClick}
                data-size={this.props.size}
                data-value={this.props.value}>
                {this.props.tipo}                
                {this.props.label}
            </div>
        );
    }
}

export default BotaoC;