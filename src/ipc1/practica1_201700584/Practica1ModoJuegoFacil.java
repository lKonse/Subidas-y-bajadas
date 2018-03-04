
package ipc1.practica1_201700584;
import java.util.Scanner;
import java.util.Random;
//Libreria Random

public class Practica1ModoJuegoFacil {
    
    int MatrizNumeros[][] = new int[10][5];
    int posicion = 0;
    String tablero[][] = new String[10][5];
    Practica1DificultadJuego dif = new Practica1DificultadJuego();
    Practica1ParametrosIniciales par = new Practica1ParametrosIniciales();
    //Llamamos a las clases para evaluar jugadores, subidas y bajadas
    
    Scanner entrada = new Scanner(System.in);
    Random aleatorio = new Random();
    
    int NumeroSubidas = par.$Subidas;
    int NumeroBajadas = par.$Bajadas;
    
    int[] subida = new int[NumeroSubidas];
    int[] bajada = new int[NumeroBajadas];
    
    int[][] Casilla = new int[5][8];
    String[][] SubyBaj = new String[5][8];
    String[][] Jugadores = new String[5][8];
    
    int ContP1 = 0, ContP2 = 0, ContP3 = 0, Dado;
    int CasillaP1 = 0, CasillaP2 = 0, CasillaP3 = 0;
    int fil, col, f, GameOver=0;
    
    public void ModoJuegoFacil(){
        
 
        NumeraciónCasillas();
        
        System.out.println("Orden de turnos: ");
        if(par.$NumJugadores == 2){
            System.out.println("1. " + par.P1);
            System.out.println("2. " + par.P2);
        
        }else if(par.$NumJugadores == 3){
            System.out.println("1. " + par.P1);
            System.out.println("2. " + par.P2);
            System.out.println("2. " + par.P3);
        }
        System.out.println("Tablero actual: ");
        //Mostramos el tablero vacio, solo con subidas y bajadas y la casilla final
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                Jugadores[col][fil] = "|_|";
            } 
        }
        Jugadores[0][0] = "|$|";
        
        SubidasyBajadas();
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            for(col = 0; col < 5; col++){
                System.out.print(Jugadores[col][fil] + " ");
            }
        }

        if(par.$NumJugadores == 2){
            do{
                //Llevamos un contador por jugador para saber a de quien es el turno de jugar

                if(ContP1 == ContP2){
                //Llamamos al metodo que contiene la jugabilidad del jugador 1
                   JugadorUno();
                }
                else if(ContP1 > ContP2){
                //Llamamos al metodo que contiene la jugabilidad del jugador 2
                   JugadorDos();
                }

            }while(GameOver != 1);
            //Repetira los turnos hasta que alguno de los jugadores llegue a la casilla 40 o mas
            
        }else if(par.$NumJugadores == 3){
            do{
                //Llevamos un contador por jugador para saber a de quien es el turno de jugar

                if(ContP1 == ContP2 && ContP1 == ContP3){
                //Llamamos al metodo que contiene la jugabilidad del jugador 1
                   JugadorUno();
                }
                else if(ContP1 > ContP2 && ContP2 == ContP3){
                //Llamamos al metodo que contiene la jugabilidad del jugador 2
                    JugadorDos();
                }
                else if(ContP2 > ContP3 && ContP1 > ContP3){
                //Llamamos al metodo que contiene la jugabilidad del jugador 2
                    JugadorTres();
                }

            }while(GameOver != 1);
        }
        
    }
     
    public void JugadorUno(){
        
        //Aqui evaluara en donde se encuentra el jugador y dejara en blanco la casilla para luego moverlo
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                if(CasillaP1 != CasillaP2 && CasillaP1 != CasillaP3){
                    if(CasillaP1 == Casilla[col][fil]){
                        Jugadores[col][fil] = "|_|";
                    }    
                }
            } 
        }
        System.out.println("");
        System.out.println("Turno del jugador: " + par.P1);
        System.out.println("Presione enter para tirar dado");
        entrada.nextLine();
        Dado = aleatorio.nextInt(7);
        
        while(Dado == 0){
            Dado = aleatorio.nextInt(7);
        }
        
        System.out.println("El dado cayo en: " + Dado);
        System.out.println("Presione enter para moverse en el tablero");
        entrada.nextLine();
        CasillaP1 = CasillaP1 + Dado;

        System.out.println("Tablero Actual:");
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            
            for(col = 0; col < 5; col++){
                
                if(CasillaP1 == Casilla[col][fil]){
                    Jugadores[col][fil] = "|" + par.P1 + "|";
                }
                
                System.out.print(Jugadores[col][fil] + " ");
                
            }
        }
        
            //Moverse al caer en una casilla de subida
            for(int b = 0; b < NumeroSubidas; b++){
                while(CasillaP1 == subida[b]){
                    System.out.println("");
                    System.out.println(par.P1 + " cayo en una casilla de subida");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia adelante");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " casillas hacia adelante");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroSubidas; u++){
                                if(CasillaP1 == subida[u]){
                                    if(CasillaP1 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|+|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP1 = CasillaP1 + Dado;
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP1 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P1 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }
            //Moverse al caer en una casilla de bajada
            for(int b = 0; b < NumeroBajadas; b++){
                while(CasillaP1 == bajada[b]){
                    System.out.println("");
                    System.out.println(par.P1 + " cayo en una casilla de bajada");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia atras");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " Casillas hacia atras");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroBajadas; u++){
                                if(CasillaP1 == bajada[u]){
                                    if(CasillaP1 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|-|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP1 = CasillaP1 - Dado;
                    if(CasillaP1 < 1){
                        CasillaP1 = 1;
                    }
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP1 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P1 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }

        ContP1++;
        
        if(CasillaP1 >= 40){
            System.out.println("");
            System.out.println("El jugador " + par.P1 + " es el ganador!!");
            System.out.println("Presione enter para salir de la partida");
            entrada.nextLine();
            GameOver = 1;
        }
        
    }
    
    public void JugadorDos(){
        
        //Aqui evaluara en donde se encuentra el jugador y dejara en blanco la casilla para luego moverlo
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                if(CasillaP2 != CasillaP1 && CasillaP2 != CasillaP3){
                    if(CasillaP2 == Casilla[col][fil]){
                        Jugadores[col][fil] = "|_|";
                    }    
                }
            } 
        }
        
        System.out.println("");
        System.out.println("Turno del jugador "+par.P2);
        System.out.println("Presione enter para tirar dado");
        entrada.nextLine();
        Dado = aleatorio.nextInt(7);
        
        while(Dado == 0){
            Dado = aleatorio.nextInt(7);
        }
        
        System.out.println("El dado cayo en: " + Dado);
        System.out.println("Presione enter para moverse en el tablero");
        entrada.nextLine();
        CasillaP2 = CasillaP2 + Dado;

        System.out.println("Tablero Actual:");
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            
            for(col = 0; col < 5; col++){

                if(CasillaP2 == Casilla[col][fil]){
                    Jugadores[col][fil] = "|" + par.P2 + "|";
                }
                System.out.print(Jugadores[col][fil] + " ");
            }
        }
        
        //Moverse al caer en una casilla de subida
            for(int b = 0; b < NumeroSubidas; b++){
                while(CasillaP2 == subida[b]){
                    System.out.println("");
                    System.out.println(par.P2 + " cayo en una casilla de subida");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia adelante");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " Casillas hacia adelante");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroSubidas; u++){
                                if(CasillaP2 == subida[u]){
                                    if(CasillaP2 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|+|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP2 = CasillaP2 + Dado;
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP2 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P2 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }
            //Moverse al caer en una casilla de bajada
            for(int b = 0; b < NumeroBajadas; b++){
                while(CasillaP2 == bajada[b]){
                    System.out.println("");
                    System.out.println(par.P2 + " cayo en una casilla de bajada");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia atras");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " Casillas hacia atras");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroBajadas; u++){
                                if(CasillaP2 == bajada[u]){
                                    if(CasillaP2 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|-|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP2 = CasillaP2 - Dado;
                    if(CasillaP2 < 1){
                        CasillaP2 = 1;
                    }
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP2 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P2 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }
        
        ContP2++;    
        
        if(CasillaP2 >= 40){
            System.out.println("");
            System.out.println("El jugador " +par.P2+ " es el ganador!!");
            System.out.println("Presione enter para salir de la partida");
            entrada.nextLine();
            GameOver = 1;
        }
    }
    
    public void JugadorTres(){
        //Aqui evaluara en donde se encuentra el jugador y dejara en blanco la casilla para luego moverlo
        for(fil = 0; fil < 8; fil++){
            for(col = 0; col < 5; col++){
                if(CasillaP3 != CasillaP1 && CasillaP3 != CasillaP2){
                    if(CasillaP3 == Casilla[col][fil]){
                        Jugadores[col][fil] = "|_|";
                    }    
                }
            } 
        }
        System.out.println("");
        System.out.println("Turno del jugador "+par.P3);
        System.out.println("Presione enter para tirar dado");
        entrada.nextLine();
        Dado = aleatorio.nextInt(7);
        
        while(Dado == 0){
            Dado = aleatorio.nextInt(7);
        }
        
        System.out.println("El dado cayo en: " + Dado);
        System.out.println("Presione enter para moverse en el tablero");
        entrada.nextLine();
        CasillaP3 = CasillaP3 + Dado;

        System.out.println("Tablero Actual:");
        
        for(fil = 0; fil < 8; fil++){
            System.out.println("");
            
            for(col = 0; col < 5; col++){
                
                if(CasillaP3 == Casilla[col][fil]){
                    Jugadores[col][fil] = "|" + par.P3 + "|";
                }
                
                System.out.print(Jugadores[col][fil] + " ");
            }
        }
        
        //Moverse al caer en una casilla de subida
            for(int b = 0; b < NumeroSubidas; b++){
                while(CasillaP3 == subida[b]){
                    System.out.println("");
                    System.out.println(par.P3 + " cayo en una casilla de subida");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia adelante");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " Casillas hacia adelante");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroSubidas; u++){
                                if(CasillaP3 == subida[u]){
                                    if(CasillaP3 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|+|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP3 = CasillaP3 + Dado;
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP3 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P3 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }
            //Moverse al caer en una casilla de bajada
            for(int b = 0; b < NumeroBajadas; b++){
                while(CasillaP3 == bajada[b]){
                    System.out.println("");
                    System.out.println(par.P3 + " cayo en una casilla de bajada");
                    System.out.println("Presione enter para ver cuantas casillas se movera hacia atras");
                    entrada.nextLine();
                    Dado = aleatorio.nextInt(13);
                    while(Dado == 0){
                        Dado = aleatorio.nextInt(13);
                    }
                    System.out.println("Se movera " + Dado + " Casillas hacia atras");
                    System.out.println("Presione enter para moverse en el tablero");
                    entrada.nextLine();
                    
                    for(fil = 0; fil < 8; fil++){
                        for(col = 0; col < 5; col++){
                            for(int u = 0; u < NumeroBajadas; u++){
                                if(CasillaP3 == bajada[u]){
                                    if(CasillaP3 == Casilla[col][fil]){
                                        Jugadores[col][fil] = "|-|";
                                    } 
                                }
                            }   
                        }
                    }
                      
                    CasillaP3 = CasillaP3 - Dado;
                    if(CasillaP3 < 1){
                        CasillaP3 = 1;
                    }
                    
                    System.out.println("Tablero Actual:");

                    for(fil = 0; fil < 8; fil++){
                        System.out.println("");

                        for(col = 0; col < 5; col++){

                            if(CasillaP3 == Casilla[col][fil]){
                                Jugadores[col][fil] = "|" + par.P3 + "|";
                            }

                            System.out.print(Jugadores[col][fil] + " ");

                        }
                    }
                }
            }
        
        ContP3++;
        
        if(CasillaP3 >= 40){
            System.out.println("");
            System.out.println("El jugador " + par.P3 + " es el ganador!!");
            System.out.println("Presione enter para salir de la partida");
            entrada.nextLine();
            GameOver = 1;
        }
    }
    
    public void SubidasyBajadas(){
        
        for(col = 0; col < NumeroSubidas; col++){
            
            for(int b = 0; b < col; b++){
                subida[col] = aleatorio.nextInt(40);
                            
                while(subida[col] == 0 || subida[col] == subida[b] || subida[col] == (subida[b]-1) 
                        || subida[col] == (subida[b]+1)){

                    subida[col] = aleatorio.nextInt(40);
                }  
            }
        }
        
        for(int u = 0; u < NumeroSubidas; u++){
            for(fil=0; fil < 8; fil++){
                for(col=0; col < 5; col++){
                
                    if(subida[u] == Casilla[col][fil]){
                        Jugadores[col][fil] = "|+|";
                        
                    }
                }  
            }
        }
        
            for(fil = 0; fil < NumeroBajadas; fil++){
                for(col = 0; col < NumeroBajadas; col++){
                    for(int b = 0; b < NumeroSubidas; b++ ){
                        bajada[col] = aleatorio.nextInt(40);

                        while(bajada[fil] == 0 || bajada[fil] == (bajada[col]-1)
                                || bajada[fil] == (bajada[fil]+1) || bajada[col] == subida[b] || bajada[col] == (subida[b]-1)
                                || bajada[col] == (subida[b]+1)){

                            bajada[col] = aleatorio.nextInt(40);
                        }   
                    }  
                }
            }

        for(int u = 0; u < NumeroBajadas; u++){
            for(fil=0; fil < 8; fil++){
                for(col=0; col < 5; col++){
                
                    if(bajada[u] == Casilla[col][fil]){
                        Jugadores[col][fil] = "|-|";
                        
                    }
                }  
            }
        }
        
    }
    
    public void NumeraciónCasillas(){
        
        int i = 1;
        int F;
        
        //Nombraremos cada casilla con un numero desde abajo hasta arriba
        for(F = 0; F < 5; F++){  
            Casilla[F][7] = F + 1; 
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][6] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][5] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][4] = 5 + i;
            i++;    
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][3] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][2] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casilla[F][1] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casilla[F][0] = 5 + i;
            i++;     
        }   
        
//        for(int aj = 0; aj < 8; aj++){
//            System.out.println("");
//            for(int y = 0; y < 5; y++){
//                System.out.print(Casilla[y][aj] + "  ");
//            }
//        }
//        entrada.nextLine();


//|| bajada[col] == subida[b] || bajada[col] == (subida[b]-1) 
//                        || bajada[col] == (subida[b]+1) 


//    posicion = 0;
//    
//    posicion = posicion + Dado;
//        
//        for(fil = 0; fil < 10; fil++){
//            System.out.println("");
//            
//            for(col = 0; col < 8; col++){
//                
//                if(posicion == MatrizNumeros[col][fil]){
//                    tablero[col][fil] = "|P1|";
//                }
//                
//                System.out.print(tablero[col][fil] + " ");
//            }
//        }
    }
    
}
