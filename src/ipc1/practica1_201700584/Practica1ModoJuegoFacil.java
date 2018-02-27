
package ipc1.practica1_201700584;
import java.util.Scanner;


public class Practica1ModoJuegoFacil {
    
    Practica1ParametrosIniciales par = new Practica1ParametrosIniciales();
    //Llamamos a las clases para evaluar jugadores, subidas y bajadas
    
    Scanner entrada = new Scanner(System.in);
    
    public void ModoJuegoFacil(){
        
        String[][] Jugadores = new String[5][8];
        int[][] Casillas = new int[5][8];
        String[][] SubyBaj = new String[5][8];
        
        int i = 1;
        int F;
        
        //Nombraremos cada casilla con un numero desde abajo hasta arriba
        for(F = 0; F < 5; F++){  
            Casillas[F][7] = F + 1; 
        }
        
        for(F = 4; F >= 0; F--){  
            Casillas[F][6] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casillas[F][5] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casillas[F][4] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casillas[F][3] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casillas[F][2] = 5 + i;
            i++;     
        }
        
        for(F = 0; F < 5; F++){  
            Casillas[F][1] = 5 + i;
            i++;     
        }
        
        for(F = 4; F >= 0; F--){  
            Casillas[F][0] = 5 + i;
            i++;     
        }
        
 
        
        
        
        
        
//        for(int aj = 0; aj < 8; aj++){
//            System.out.println("");
//            for(int y = 0; y < 5; y++){
//                System.out.print(Casillas[y][aj] + "  ");
//            }
//        }
    }
    
}
