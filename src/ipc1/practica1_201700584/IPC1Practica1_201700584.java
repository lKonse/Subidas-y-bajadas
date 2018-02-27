
package ipc1.practica1_201700584;
import java.util.Scanner;

public class IPC1Practica1_201700584 {

    
    public static void main(String[] args) {
        
       Scanner entrada = new Scanner(System.in);
       int OpMenuPrincipal = 0;
       
       do{
           //Menu Principal del juego
           System.out.println("1. Dificultad del juego");
           System.out.println("2. Parametros del juego");
           System.out.println("3. Iniciar juego");
           System.out.println("4. Salir");
           System.out.println();
           System.out.print("Escoja un opcion: ");
           OpMenuPrincipal = entrada.nextInt();
           System.out.println();
           
           switch(OpMenuPrincipal){
               
               case 1:
                   Practica1DificultadJuego b = new Practica1DificultadJuego();
                   b.MenuDificultad();
                   break;
                
               case 2:
                   break;
                   
               case 3:
                   break;
                   
               case 4:
                   break;
                   
               default:
                   break;
               
           }
           
       }while(OpMenuPrincipal != 4);

    }
    
}
