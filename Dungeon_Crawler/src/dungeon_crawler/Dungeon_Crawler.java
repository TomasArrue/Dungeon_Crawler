/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_crawler;

/**
 *
 * @autor Tomas Arrue
 */
import PaqueteLectura.Lector;
public class Dungeon_Crawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("primer paso; cargar el mapa");
        System.out.println("");
        Mapa test = new Mapa();
        System.out.println("segundo paso; el mapa fue cargado");
        System.out.println("");
        System.out.println("");
        System.out.println("tercer paso; imprimer el mapa");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        test.posInicial(1, 1);
        test.imprimirMapa();
        System.out.println("");
        System.out.println("");
        System.out.println("escribir 'd' para mover arriba");
        char aux = 'd';
        test.chekMove(aux);
        System.out.println("");
        System.out.println("");
        test.imprimirMapa();
        System.out.println("");
        System.out.println("");
        Lado ladoAux = new Lado('m',false);
        test.actualizarCelda(5, 5, ladoAux, ladoAux, ladoAux, ladoAux, null);
        System.out.println("se cerro la celda en la pos [6][6]");
        test.mapoff();
        test.imprimirMapa();
        System.out.println("");
        System.out.println("");
        int c = Lector.leerInt();
        while (c != 0){   
            if(c == 1){
                test.chekMove('w');
                test.imprimirMapa();
                System.out.println("");
                System.out.println("");
            }
            else{
                if(c == 2){
                    test.chekMove('s');
                    test.imprimirMapa();
                    System.out.println("");
                    System.out.println("");                    
                }
                else{
                    if(c == 3){
                        test.chekMove('d');
                        test.imprimirMapa();
                        System.out.println("");
                        System.out.println("");                    
                    }
                    else{
                        if(c == 4){
                            test.chekMove('a');
                            test.imprimirMapa();
                            System.out.println("");
                            System.out.println("");                        
                        }
                        else{
                            System.out.println("comando erroneo");
                            test.imprimirMapa();
                            System.out.println("");
                            System.out.println("");   
                        }
                    }
                }
            }
            c = Lector.leerInt();
        }
        test.imprimirMapa();
        System.out.println("");
        System.out.println("");
        System.out.println("paso final; presiona enter para terminar");
        String fin;
        fin = Lector.leerString();
        
        
        /*int x = 1;  ///////////Test incrementar y decrementar
        
        System.out.println("X fue inicializada en '1': " + x);
        System.out.println("");
        System.out.println("X va a ser modificada por '++x': " + ++x);
        System.out.println("");
        System.out.println("X vuleve a ser imprimida: " + x);
        System.out.println("");
        System.out.println("X va a ser modificada por 'x++': " + x++);
        System.out.println("");
        System.out.println("X vuleve a ser imprimida: " + x);
        x = Lector.leerInt();
        */        
    }
    
}
