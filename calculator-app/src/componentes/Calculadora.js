"use strict";

//Projeto: calculadora-app
//Codigo: estrutura basica da calculadora
//Autora: Carla Edila Silveira
//Finalidade: estabelece a classe Calculator e botoes


import React, {Component} from 'react';
import BotaoC from './Botao';
import './Calculadora.css';
import VisorC from './Visor';
import TecladoC from './Teclado';


class CalculadoraApp extends Component {
    constructor() {
        super();
        this.state = { data: ''}
    }

    calculate = () => {
        try {
            const result = eval(this.state.data);
            this.setState({data: result});
        } catch (e) {
            this.setState({data: 'error'})
        }
    }

    handleClick = e => {
        const value = e.target.getAttribute('data-value');
        switch(value) {
            case 'clear':
                this.setState({ data: ''});
                break;
		case 'erase':
		    this.setState({ data: this.state.data.slice(0, -1)}); 
	          break;
            case 'equal':
                this.calculate();
                break;
            default:
                this.setState({ data: this.state.data + value});
        }
    }
   
    render(){
        return(
            <div className="CalculadoraApp">
                <VisorC data={this.state.data}/>
                <TecladoC>
                    <BotaoC onClick={this.handleClick} label="+" value="+" />
                    <BotaoC onClick={this.handleClick} label="7" value="7" />
                    <BotaoC onClick={this.handleClick} label="4" value="4" />
                    <BotaoC onClick={this.handleClick} label="1" value="1" />
                    <BotaoC onClick={this.handleClick} label="0" value="0" />

                    <BotaoC onClick={this.handleClick} label="-" value="-" />
                    <BotaoC onClick={this.handleClick} label="8" value="8" />
                    <BotaoC onClick={this.handleClick} label="5" value="5" />
                    <BotaoC onClick={this.handleClick} label="2" value="2" />
                    <BotaoC onClick={this.handleClick} label="." value="." />

                    <BotaoC onClick={this.handleClick} label="/" value="/" />
                    <BotaoC onClick={this.handleClick} label="9" value="9" />
                    <BotaoC onClick={this.handleClick} label="6" value="6" />
                    <BotaoC onClick={this.handleClick} label="3" value="3" />
                    <BotaoC onClick={this.handleClick} label="%" value="/100" />
                                        
                    <BotaoC onClick={this.handleClick} label="x" value="*" />
                    <BotaoC onClick={this.handleClick} label="CE" value="erase" />
                    <BotaoC onClick={this.handleClick} label="C" value="clear" />
                    <BotaoC onClick={this.handleClick} label="=" size="2" value="equal" />
                  </TecladoC>
            </div>
        ); 
    }
}

export default CalculadoraApp;