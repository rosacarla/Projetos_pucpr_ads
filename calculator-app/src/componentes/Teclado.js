"use strict";

//Projeto: calculadora-app
//Codigo: teclado
//Autora: Carla Edila Silveira
//Finalidade: componente exibe o teclado da calculadora 

import React, {Component} from 'react';
import "./Teclado.css";

class TecladoC extends Component {
    render(){
        return(
            <div className="TecladoC">
                {/* Foi usada composicao em vez de heranca. */}
                {this.props.children}
            </div>
        );
    }
}

export default TecladoC;