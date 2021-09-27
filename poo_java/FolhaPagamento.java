/*
 * Código: POO Folha de pagamento
 Função: calcular salários de tipos distintos de funcionário e imprimir a FP
 * Data: 09/06/2020
 */
package javaapplication10.sistema.folha.pagamento;

import java.util.Scanner; //biblioteca de leitura
import java.util.Calendar;//biblioteca de calendário

/**
 *
 * @author Carla Edila
 */

public class FolhaPagamento { //implementação da superclasse Folha de Pagamento

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //entrada da quantidade de elementos/objetos
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe a quantidade de funcionários: ");
        int qtdeFuncionarios = teclado.nextInt(); teclado.nextLine();
        
        //implementação de vetores?
        int[] fcCodigo = new int[qtdeFuncionarios];
        int[] fcTipo = new int[qtdeFuncionarios];
        double[] fcSalbase = new double[qtdeFuncionarios];
        int[] fcTempo = new int[qtdeFuncionarios];
          
        int c = 0;
    
        //leitura do conjunto de dados dos objetos?
        while (c < qtdeFuncionarios) {
                                                    
            System.out.println("==== FUNCIONÁRIO "+ c +" DA FOLHA DE PAGAMENTO ===="); 
            System.out.println("Informe o código do funcionário: \n");
            fcCodigo[c] = teclado.nextInt();teclado.nextLine();
            
            System.out.println("Informe o salário-base do funcionário: \n");
            fcSalbase[c] = teclado.nextInt();teclado.nextLine();    
            
            System.out.println("Informe o tipo de funcionário: \n");
            System.out.println("1 - Concursado"); //tempo de serviço em anos
            System.out.println("2 - Temporário\n");//tempo de contrato em meses
            fcTipo[c] = teclado.nextInt();teclado.nextLine();
            
            //condição 1
            if (fcTipo[c] == 1){
                
                System.out.println("Infome tempo de serviço em anos: ");
                fcTempo[c] = teclado.nextInt();teclado.nextLine();
                
            }
            else{ //condição 2
                
               System.out.println("Infome tempo de contratação em meses: ");
               fcTempo[c] = teclado.nextInt();teclado.nextLine();
                
            }
               
            c++;
            
        }
        
    } //impressão dos dados de cada objeto por classe
    public class Testa_Metodo_Get_Calendar{ //implantação classe calendário/mês
                                            // para impressão pode ser aqui?    
        public void main(String[] args) {
            Calendar b = Calendar.getInstance();
            
        }
        //grupo de concursados        
        for (int i = 0; i <qtdeFuncionarios; i++){
    
            if (fcTipo[i] == 1){
                System.out.println("==== FOLHA DE PAGAMENTO ** MÊS DE "+b.get(Calendar.MAY)+" ** FUNCIONÁRIOS CONCURSADOS ====");
                System.out.println("\n"+fcCodigo[i]+":"+fcSalbase[i]+"\n");
             
            }
        }
        //grupo de temporários
        for (int i = 0; i < qtdeFuncionarios; i++){
        
            if (fcTipo[i] == 2){
                System.out.println("==== FOLHA DE PAGAMENTO ** MÊS DE "+b.get(Calendar.MAY)+" ** FUNCIONÁRIOS TEMPORÁRIOS ====");
                System.out.println("\n"+fcCodigo[i]+":"+fcSalbse[i]+"\n");
                         
            }
        
        }
    }
    
}
