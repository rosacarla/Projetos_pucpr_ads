package soap;

import javax.jws.WebMethod;

import javax.jws.WebParam;

import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.jws.soap.SOAPBinding.Style;

 

@WebService

@SOAPBinding(style = Style.RPC)

public class Calculator {
	@WebMethod(action = "add")

    public int add(

                 @WebParam(name = "number1") int number1,

                 @WebParam(name = "number2") int number2) {

          return number1 + number2;
    } 
	
	
	@WebMethod(action = "subtract")

    public int subtract(

                 @WebParam(name = "number1") int number1,

                 @WebParam(name = "number2") int number2) {

          return number1 - number2;
	}
	
	
	@WebMethod(action = "multiply")

    public double multiply(

                 @WebParam(name = "number1") double number1,

                 @WebParam(name = "number2") double number2) {

          return number1 * number2;
	}
	
	@WebMethod(action = "divide")

    public double divide(

                 @WebParam(name = "number1") double number1,

                 @WebParam(name = "number2") double number2) {

          return number1 / number2;
	}

}
