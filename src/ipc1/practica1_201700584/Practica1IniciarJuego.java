
package ipc1.practica1_201700584;

import java.util.Scanner;


public class Practica1IniciarJuego {
    
    Scanner entrada = new Scanner(System.in);
    Practica1DificultadJuego dif = new Practica1DificultadJuego();
    Practica1ParametrosIniciales par = new Practica1ParametrosIniciales();
    //Llamamos a las clases para evaluar dificultad, jugadores, subidas y bajadas
    
    public void Juego(){
        
        Practica1ModoJuegoFacil modo1 = new Practica1ModoJuegoFacil();
        //Llamamos a la clase que contiene el modo de juego facil
        
        Practica1ModoJuegoDificil modo2 = new Practica1ModoJuegoDificil();
        //Llamamos a la clase que contiene el modo de juego Dificil
        
        String evaluar = dif.$Dificultad;
        
        if(evaluar.contains("Facil")){
            
            modo1.ModoJuegoFacil();
            
        }else if(evaluar.contains("Dificil")){
            
            modo2.ModoJuegoDificil();
            
        }
        
    }
    
    public void Enter(){
        Scanner Enter = new Scanner(System.in);
        System.out.println();
        System.out.println("Presione enter para continuar");
        Enter.nextLine();
    }
    
}
