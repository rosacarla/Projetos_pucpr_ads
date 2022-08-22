package soap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import exception.DivisaoPorZeroException;
 
@SuppressWarnings("rawtypes")
private boolean autenticar (WebServiceContext context) throws
Exception {
	
	MessageContext mc = context.getMessageContext();
	Map httpHeaders = (Map)
mc.get(MessageContext.HTTP_REQUEST_HEADERS); {
	
	if (!httpHeaders.containsKey("usuario"))
		throw new Exception("Informe um usuario");
	
	if (!httpHeaders.containsKey("senha"))
		throw new Exception("Informe uma senha");
	
	String usuario = ((List)
httpHeaders.get("usuario")).get(0).toString();
	String senha = ((List)
httpHeaders.get("senha")).get(0).toString();
	
	if (usuario.equals("sisfin") && senha.equals("sisfin123"))
{
		return true;
	} else {
		throw new Exception("Usuario e senha invalido");
	}
}

@WebService
@SOAPBinding(style = Style.RPC)
public class Calculator {
	
	@Resource
	WebServiceContext context;
	
	@WebMethod(action = "add")
    public int add(

                 @WebParam(name = "number1") int number1,
                 @WebParam(name = "number2") int number2) throws
    Exception {
		
        autenticar(context);  
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

                 @WebParam(name = "number2") double number2) throws DivisaoPorZeroException {
		
		  if (number2 == 0) {
			  	throw new DivisaoPorZeroException();
		  }

          return number1 / number2;
	}

}}
