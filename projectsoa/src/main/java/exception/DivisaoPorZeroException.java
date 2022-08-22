package exception;

import javax.xml.ws.WebFault;

@WebFault(name = "DivisaoPorZero")
public class DivisaoPorZeroException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DivisaoPorZeroException() {
		super("Divisao por zero nao é permitida!");
	}

}
