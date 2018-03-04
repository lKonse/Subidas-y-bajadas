
package ipc1.practica1_201700584;
import java.util.Scanner;
import java.util.Random;

public class Practica1ParametrosIniciales {
    
    Scanner entrada = new Scanner(System.in);
    Random aleat = new Random();
    Practica1DificultadJuego llamar = new Practica1DificultadJuego();
    //Se llama la clase de para poder consultar la variable $Dificultad y saber que juego se llevara acabo
    
    static int $NumJugadores, $Subidas, $Bajadas, turno;
    static String P1, P2, P3;
    String[] jugador = new String[3];
    //Variables que el juego consultara para el desarrollo del juego
    
    
    public void MenuParametros(){
        
        int OpMenuParametros;
        
        String evaluar = llamar.$Dificultad;
        
        do{
         //Menu de Parametros del juego
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

                if(evaluar.equals("Facil")){
                    //Llamamos al metodo que contiene los parametros para jugadores en modo Facil
                    EasyJugadores();
                }
                
                else if(evaluar.equals("Dificil")){
                    //Llamamos al metodo que contiene los parametros para jugadores en modo Dificil
                    HardJugadores();    
                }
                
                Enter();
                break;
                
            case 2:
                
                if(evaluar.equals("Facil")){
                    //Llamamos al metodo que contiene los parametros para Subidas y bajadas en modo Facil
                    EasySubBaj();
                }
                
                else if(evaluar.equals("Dificil")){
                    //Llamamos al metodo que contiene los parametros para Subidas y bajadas en modo Dificil
                    HardSubBaj();
                }
                
                Enter();
                break;
                
            case 3:
                break;
                
            default:
                break;
            
        }
        
        }while(OpMenuParametros != 3);
        
    }
    public void EasyJugadores(){

        System.out.print("Numero de jugadores: ");
        $NumJugadores = entrada.nextInt();
        //Pedimos el numero de jugadores
                    
        while($NumJugadores < 2 && $NumJugadores > 3){
        //Evaluamos que se ingresen entre 2 o 3 jugadores, de lo contrario se pedira ingresar de nuevo el numero de jugadores
        
            System.out.println();
            System.out.println("Deben jugar entre 2 o 3 jugadores");
            System.out.print("Numero de jugadores: ");
            $NumJugadores = entrada.nextInt();
        }
                    
        if($NumJugadores == 2){
        //Evaluamos que si fueron 2 jugadores pedira que ingrese los simbolos de cada jugador    
            System.out.println();
                        
            System.out.print("Ingrese el simbolo del jugador 1: ");
            jugador[0] = entrada.next();
                        
            System.out.print("Ingrese el simbolo del jugador 2: ");
            jugador[1] = entrada.next();
                        
            System.out.println("Usuarios ingresados con exito");
            
            //Ingresa un numero aleatorio de 0 a 1 en la posicion matriz para definir los turnos
            turno = aleat.nextInt(2);
            
            P1 = jugador[turno];
            
            turno = aleat.nextInt(2);
            P2 = jugador[turno];
            
            while(P2.equals(P1)){
                turno = aleat.nextInt(2);
                P2 = jugador[turno];
            }
                        
        }
                    
        if($NumJugadores == 3){
         //Evaluamos que si fueron 3 jugadores pedira que ingrese los simbolos de cada jugador 
         
             System.out.println();
                        
            System.out.print("Ingrese el simbolo del jugador 1: ");
            jugador[0] = entrada.next();
                        
            System.out.print("Ingrese el simbolo del jugador 2: ");
            jugador[1] = entrada.next();
            
            System.out.print("Ingrese el simbolo del jugador 3: ");
            jugador[2] = entrada.next();
                        
            System.out.println("Usuarios ingresados con exito");
            
            //Ingresa un numero aleatorio de 0 a 2 en la posicion matriz para definir los turnos
            turno = aleat.nextInt(3);
            
            P1 = jugador[turno];
            
            turno = aleat.nextInt(3);
            P2 = jugador[turno];
            
            while(P2.equals(P1)){
                turno = aleat.nextInt(3);
                P2 = jugador[turno];
            }
            
            turno = aleat.nextInt(3);
            P3 = jugador[turno];
            
            while(P3.equals(P1) || P3.equals(P2)){
                turno = aleat.nextInt(3);
                P3 = jugador[turno];
            }
        }
    }
    
    public void HardJugadores(){
        
    }
    
    public void EasySubBaj(){
        System.out.print("Numero de subidas: ");
        $Subidas = entrada.nextInt();
        //Pedimos que se ingrese el nuemro se subidas que tendra el juego
        
        while($Subidas < 5 || $Subidas > 10){
        //Evaluamos que las subidas sean entre 5 y 10, de lo contrario se pedira que se ingrese de nuevo el numero de subidas
            
            System.out.println();
            System.out.println("El numero se subidas debe ser entre 5 y 10");
            System.out.print("Numero de subidas: ");
            $Subidas = entrada.nextInt();
        }
        
        System.out.print("Numero de bajadas: ");
        $Bajadas = entrada.nextInt();
        
        while($Bajadas < 5 || $Bajadas > 10){
        //Evaluamos que las bajadas sean entre 5 y 10, de lo contrario se pedira que se ingrese de nuevo el numero de bajadas
            
            System.out.println();
            System.out.println("El numero se bajadas debe ser entre 5 y 10");
            System.out.print("Numero de bajadas: ");
            $Bajadas = entrada.nextInt();
        }
 
        
        System.out.println("Subidas y bajadas ingresadas correctamente");
    }
    
    public void HardSubBaj(){
        
    }
    
    public void Enter(){
        Scanner Enter = new Scanner(System.in);
        System.out.println();
        System.out.println("Presione enter para continuar");
        Enter.nextLine();
    }
    
}
