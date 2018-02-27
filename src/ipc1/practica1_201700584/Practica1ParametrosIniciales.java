
package ipc1.practica1_201700584;
import java.util.Scanner;

public class Practica1ParametrosIniciales {
    
    Scanner entrada = new Scanner(System.in);
    Practica1DificultadJuego llamar = new Practica1DificultadJuego();
    
    static int $NumJugadores;
    static String P1, P2, P3;
    
    
    public void MenuParametros(){
        
        int OpMenuParametros;
        
        
        do{
        System.out.println("PARAMETROS DEL JUEGO:");
        System.out.println("1. Jugadores");
        System.out.println("2. Subidas y bajadas");
        System.out.println("3. Salir al menu principal");
        System.out.println();
        System.out.print("Escoja una opcion: ");
        OpMenuParametros = entrada.nextInt();
        System.out.println();
        
        switch(OpMenuParametros){
            
            case 1:
                String evaluar = llamar.$Dificultad;
                
                if(evaluar.equals("Facil")){
                Easy();
                }
                
                else if(evaluar.equals("Dificil")){
                Hard();    
                }
                break;
                
            case 2:
                Hard();
                break;
                
            case 3:
                break;
                
            default:
                break;
            
        }
        
        }while(OpMenuParametros != 3);
        
    }
    public void Easy(){

        System.out.print("Numero de jugadores: ");
        $NumJugadores = entrada.nextInt();
                    
        while($NumJugadores == 0){
            System.out.println("Deben jugar como minimo 2 jugadores");
            System.out.print("Numero de jugadores: ");
            $NumJugadores = entrada.nextInt();
        }
        while($NumJugadores <= 1){
            System.out.println("Deben jugar como minimo 2 jugadores");
            System.out.print("Numero de jugadores: ");
            $NumJugadores = entrada.nextInt();
        }
        while($NumJugadores >= 4){
            System.out.println("EL maximo de jugadores debe ser de 3");
            System.out.print("Numero de jugadores: ");
            $NumJugadores = entrada.nextInt();
        }
                    
        if($NumJugadores == 2){
                        
            System.out.print("Ingrese el simbolo del jugador 1: ");
            P1 = entrada.next();
                        
            System.out.print("Ingrese el simbolo del jugador 2: ");
            P2 = entrada.next();
                        
            System.out.println("Usuarios ingresados con exito");
                        
        }
                    
        if($NumJugadores == 3){
                        
            System.out.print("Ingrese el simbolo del jugador 1: ");
            P1 = entrada.next();
                        
            System.out.print("Ingrese el simbolo del jugador 2: ");
            P2 = entrada.next();
                        
            System.out.print("Ingrese el simbolo del jugador 3: ");
            P3 = entrada.next();
                        
            System.out.println("Usuarios ingresados con exito");
        }
        Enter();
    }
    
    public void Hard(){
        
    }
    
    public void Enter(){
        Scanner Enter = new Scanner(System.in);
        System.out.println();
        System.out.println("Presione enter para continuar");
        Enter.nextLine();
    }
    
}
