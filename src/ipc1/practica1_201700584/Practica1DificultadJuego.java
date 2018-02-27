
package ipc1.practica1_201700584;
import java.util.Scanner;
        
public class Practica1DificultadJuego {
    
    static String $Dificultad;
    
    

    public void MenuDificultad(){
        
        Scanner entrada = new Scanner(System.in);
        
        int OpMenuDificultad;
        
        do{
        System.out.println("DIFICULTAD DEL JUEGO:");
        System.out.println("1. Facil");
        System.out.println("2. Dificil");
        System.out.println("3. Salir al menu principal");
        System.out.println();
        System.out.print("Escoja una opcion: ");
        OpMenuDificultad = entrada.nextInt();
        System.out.println();
        
        switch(OpMenuDificultad){
            
            case 1:
                $Dificultad = "Facil";
                
                System.out.println("Dificultad facil seleccionada");
                System.out.println("Jugadores de 2 a 3");
                System.out.println("Subidas de 5 a 10");
                System.out.println("Bajadas de 5 a 10");
                Enter();
                break;
                
            case 2:
                $Dificultad = "Dificil";
                
                System.out.println("Dificultad facil seleccionada");
                System.out.println("Jugadores de 2 a 3");
                System.out.println("Subidas de 20 a 40");
                System.out.println("Bajadas de 20 a 40");
                Enter();
                break;
                
            case 3:
                break;
                
            default:
                break;
            
        }
        
        }while(OpMenuDificultad != 3);
    
    }
    
    public void Enter(){
        Scanner Enter = new Scanner(System.in);
        System.out.println();
        System.out.println("Presione enter para continuar");
        Enter.nextLine();
    }
    
}
