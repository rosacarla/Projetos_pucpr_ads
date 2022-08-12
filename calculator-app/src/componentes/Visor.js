"use strict";

//Projeto: calculadora-app
//Codigo: visor da calculadora
//Autora: Carla Edila Silveira
//Finalidade: componente exibe resultados 

import React, {Component} from 'react';
import "./Visor.css";

class VisorC extends Component {
    render(){
        return(
            <div className="VisorC">
                {this.props.data}
            </div>
        );
    }
}

export default VisorC;