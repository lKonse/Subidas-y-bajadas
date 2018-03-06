
package ipc1.practica1_201700584;
import java.util.Scanner;
        
public class Practica1DificultadJuego {
    
    static String $Dificultad = " ";
    //La variable que definira que dificultad llevara el juego
    

    public void MenuDificultad(){
        
        Scanner entrada = new Scanner(System.in);
        
        int OpMenuDificultad;
        Practica1ParametrosIniciales par = new Practica1ParametrosIniciales();
        

        //Menu de la dificultad de juego
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
                //Se le asigna a la variable la dificultad, con esto el juego sabra que se debe desarrolar en "Facil"
                
                System.out.println("Dificultad facil seleccionada");
                System.out.println("Jugadores de 2 a 3");
                System.out.println("Subidas de 5 a 10");
                System.out.println("Bajadas de 5 a 10");
                Enter();
                par.MenuParametros();
                break;
                
            case 2:
                $Dificultad = "Dificil";
                //Se le asigna a la variable la dificultad, con esto el juego sabra que se debe desarrolar en "Dificil"
                
                System.out.println("Dificultad dificil seleccionada");
                System.out.println("Jugadores de 2 a 4");
                System.out.println("Subidas de 20 a 40");
                System.out.println("Bajadas de 20 a 40");
                Enter();
                par.MenuParametros();
                break;
                
            case 3:
                break;
                
            default:
                break;
            
        }
        
    
    }
    
    public void Enter(){
        //Metodo para que el programa continue si el usuario pulsa enter
        Scanner Enter = new Scanner(System.in);
        System.out.println();
        System.out.println("Presione enter para continuar a parametros del juego");
        Enter.nextLine();
    }
    
}
