package soap;

import javax.jws.WebMethod;

import javax.jws.WebParam;

import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.jws.soap.SOAPBinding.Style;

 

import bean.ListaUF;

import bean.UF;

 

@WebService

@SOAPBinding(style = Style.RPC)

public class BuscadorUF {
	
	String[][] listaUFs =

        {

                { "Rio Branco", "Acre", "413418" },

                { "Alagoas", "Macei�", "1025360" },                    

                { "Acre", "Rio Branco", "413418" },

                {"Alagoas" , "Macei�", "1025360" },                                    

                {"Amazonas", "Manaus", "2219580" },

                {"Amap�", "Macap�", "512902" },

                {"Bahia", "Salvador", "2886698"},

                {"Cear�", "Fortaleza", "2686612"},

                {"Distrito Federal", "Bras�lia", "3055149"},

                {"Esp�rito Santo", "Vit�ria", "365855"},

                {"Goi�s", "Goi�nia", "1536097"},

                {"Maranh�o", "S�o Lu�s", "1108975"},

                {"Minas Gerais", "Belo Horizonte", "2521564"},

                {"Mato Grosso", "Cuiab�", "618124"},

                {"Mato Grosso do Sul", "Campo Grande", "906092"},

                {"Par�", "Bel�m", "1499641"},

                {"Para�ba", "Jo�o Pessoa", "817511"},

                {"Paran�", "Curitiba", "1948626"},

                {"Pernambuco", "Recife", "1653461"},

                {"Piau�", "Teresina", "868075"},

                {"Rio de Janeiro", "Rio de Janeiro", "6747815"},

                {"Rio Grande do Norte", "Natal", "890480"},

                {"Rio Grande do Sul", "Porto Alegre", "1488252"},

                {"Rond�nia", "Porto Velho", "539354"},

                {"Roraima", "Boa Vista", "419652"},

                {"Santa Catarina", "Florian�polis", "508826"},

                {"S�o Paulo", "S�o Paulo", "12325232"},

                {"Sergipe", "Aracaju", "664908"},

                {"Tocantins", "Palmas", "306296"},

        };



	@WebMethod(action = "listarUFs")
	public ListaUF listarUFs() {
		
		ListaUF ufs = new ListaUF();
        for (String[] uf : listaUFs) {
        	ufs.getUFs().add(new UF(uf[0], uf[1], uf[2]));
        }
        return ufs;
	}
	
	
	@WebMethod(action = "buscarUFs")	
	public ListaUF buscarUFs(@WebParam(name = "busca") String busca) throws Exception {
		
		ListaUF ufs = new ListaUF();
		for (String uf[] : listaUFs) {
			if (uf[0].toLowerCase().contains(busca.toLowerCase())) {
				ufs.getUFs().add(new UF(uf[0], uf[1], uf[2]));
			}
		}
		return ufs;		
	}
	
	
	@WebMethod(action = "buscarporCapitais")	
	public ListaUF buscarporCapitais(@WebParam(name = "busca") String busca) throws Exception {
		
		ListaUF ufs = new ListaUF();
		for (String uf[] : listaUFs) {
			if (uf[1].toLowerCase().contains(busca.toLowerCase())) {
				ufs.getUFs().add(new UF(uf[0], uf[1], uf[2]));
			}
		}
		return ufs;
	}
	
	
	@WebMethod(action = "buscarHabitantesSuperiorA")
	public ListaUF buscarHabitantesSuperiorA(@WebParam(name = "habitantes") int habitantes) {
		
		ListaUF ufs = new ListaUF();
		for (String uf[] : listaUFs) {
			if (Integer.parseInt(uf[2]) > habitantes) {
				ufs.getUFs().add(new UF(uf[0], uf[1], uf[2]));
			}
		}
		return ufs;
	}
	
	
	@WebMethod(action = "buscarUfsMenosHabitantes")
	public ListaUF buscarUfsMenosHabitantes(@WebParam(name = "habitantes") int habitantes) {
		
		ListaUF ufs = new ListaUF();
		for (String uf[] : listaUFs) {
			if (Integer.parseInt(uf[2]) < habitantes) {
				ufs.getUFs().add(new UF(uf[0], uf[1], uf[2]));
			}
		}
		return ufs;
	}    
}    