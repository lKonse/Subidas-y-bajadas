
package ipc1.practica1_201700584;
import java.util.Scanner;

public class IPC1Practica1_201700584 {

    
    public static void main(String[] args) {
        
       Scanner entrada = new Scanner(System.in);
       int OpMenuPrincipal;
       
       do{
           //Menu Principal del juego
           System.out.println("1. Dificultad del juego");
           System.out.println("2. Parametros del juego");
           System.out.println("3. Iniciar juego");
           System.out.println("4. Salir");
           System.out.println();
           System.out.print("Escoja una opcion: ");
           OpMenuPrincipal = entrada.nextInt();
           System.out.println();
           
           switch(OpMenuPrincipal){
               
               case 1:
                   //Llamamos al metodo que definira la dificultad
                   Practica1DificultadJuego DifJuego = new Practica1DificultadJuego();
                   DifJuego.MenuDificultad();
                   break;
                
               case 2:
                   //Llamamos al metodo que definira los parametros dentro del juego
                   Practica1ParametrosIniciales ParaJuego = new Practica1ParametrosIniciales();
                   ParaJuego.MenuParametros();
                   break;
                   
               case 3:
                   //Iniciamos el juego ya que se establecio dificultad y parametros
                   Practica1IniciarJuego iniciar = new Practica1IniciarJuego();
                   iniciar.Juego();
                   break;
                   
               case 4:
                   break;
                   
               default:
                   break;
               
           }
           
       }while(OpMenuPrincipal != 4);

    }
    
}
