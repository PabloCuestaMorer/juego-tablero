/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal_1ºtrimestre;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class TrabajoFinal_1ºTrimestre {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        final int LARGO_TABLERO = 5;
        final int ANCHO_TABLERO = 5;

        //Defino las variable correspondientes a los jugadores y a los espacios vacíos
        final char icoRelleno = '*';
        final char icoBuenos = 'I';
        final char icoMalos = 'V';
        int vidas = 3;

        //Defino el tablero de juego, que es una matriz bidimensional
        char tablero[][] = new char[LARGO_TABLERO][ANCHO_TABLERO];

        //Inicio tablero
        tablero = iniciarTablero(tablero, icoRelleno, icoBuenos, icoMalos);
        mostrarTablero(tablero);
        
//
//        while (vidas > 0) {
//            System.out.println(" ");
//
//            //Ahora le pregunto al usuario en que dirección quiere moverse,para ello
//            //deberá pulsar una letra del teclado,para cada dirección una letra
//            System.out.println("¿En qué dirección quieres mover al indio?");
//            respuesta = reader.next().charAt(0);
//
//            //Ahora defino lo que ocurrirá dependiendo la tecla que pulse el usuario
//            switch (Character.toUpperCase(respuesta)) {
//
//                case 'W':
//                    if (x_jugador1 - 1 >= 0) {
//                        tablero[x_jugador1][y_jugador1] = 'C';
//                        if (tablero[x_jugador1 - 1][y_jugador1] == 'V') {
//                            vidas--;
//                            tablero[x_jugador1 - 1][y_jugador1] = 'I';
//                        } else {
//
//                            tablero[x_jugador1 - 1][y_jugador1] = 'I';
//                        }
//
//                        x_jugador1--;
//
//                    }
//
//                    break;
//
//                case 'S':
//                    if (x_jugador1 + 1 >= 0) {
//                        tablero[x_jugador1][y_jugador1] = 'C';
//                        if (tablero[x_jugador1 + 1][y_jugador1] == 'V') {
//                            vidas--;
//                            tablero[x_jugador1 + 1][y_jugador1] = 'I';
//                        } else {
//
//                            tablero[x_jugador1 + 1][y_jugador1] = 'I';
//                        }
//
//                        x_jugador1++;
//
//                    }
//
//                    break;
//
//                case 'D':
//                    if (y_jugador1 + 1 >= 0) {
//                        tablero[x_jugador1][y_jugador1] = 'C';
//                        if (tablero[x_jugador1][y_jugador1 + 1] == 'V') {
//                            vidas--;
//                            tablero[x_jugador1][y_jugador1 + 1] = 'I';
//                        } else {
//
//                            tablero[x_jugador1][y_jugador1 + 1] = 'I';
//                        }
//
//                        y_jugador1++;
//
//                    }
//                    break;
//
//                case 'A':
//                    if (y_jugador1 - 1 >= 0) {
//                        tablero[x_jugador1][y_jugador1] = 'C';
//                        if (tablero[x_jugador1][y_jugador1 - 1] == 'V') {
//                            vidas--;
//                            tablero[x_jugador1][y_jugador1 - 1] = 'I';
//                        } else {
//
//                            tablero[x_jugador1][y_jugador1 - 1] = 'I';
//                        }
//
//                        y_jugador1--;
//
//                    }
//                    break;
//
//                default:
//
//            }
    }
    /**
     * Inicia el tablero con sus personajes correspondientes
     * 
     * @param tablero
     * @param icoRellenos
     * @param icoBuenos
     * @param icoMalos
     * @return char [][]
     */
    public static char[][] iniciarTablero (char[][] tablero, char icoRellenos, char icoBuenos, char icoMalos) {
        
   
        //Rellenamos tablero
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                tablero[x][y] = icoRellenos;
            }
        }
        
        //Insertar personajes
        Random random = new Random();
        tablero[random.nextInt(tablero.length)][random.nextInt(tablero.length)] = icoBuenos;
        
        int contadorMalos = 0;
        while (contadorMalos < 5) {    
            int x = random.nextInt(tablero.length);
            int y = random.nextInt(tablero.length);
            if (tablero[x][y] == icoRellenos) {
               tablero[x][y] = icoMalos;
               contadorMalos++;
            }
        }
       
        return tablero;
    }
    
    /**
     * Muestra el tablero por consola.
     * @param tablero
     */
    public static void mostrarTablero(char[][] tablero) {
        for (int x = 0; x < tablero.length; x++) {
            System.out.println(" ");
            for (int y = 0; y < tablero[x].length; y++) {
                System.out.print(tablero[x][y] + " ");
            }
        }
    }
}
