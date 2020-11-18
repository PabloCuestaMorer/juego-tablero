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
        // TODO code application logic here

        Random random = new Random();

        Scanner reader = new Scanner(System.in);

//Defino la varible correspondiente a las vidas del jugador, estas iran decreciendo
//dependiendo con lo que cohoque el jugador al moverse una casilla
        int vidas = 3;

        //Defino la varaible que hace referencia a la tecla que pulsará el usuario
        //en el teclado
        char respuesta = ' ';

        

        //Defino lad variables que me ayudarán a repartir a los personajes de los
        //jugadores (indios y vaqueros) un número determinado de veces.
        int contador_jugador2 = 0;

        final int FILA_TABLERO = 5;
        final int COLUMNA_TABLERO = 5;

        //Defino las variable correspondientes a los jugadores y a los espacios vacíos
        final char relleno = 'C';
        final char buenos_J1 = 'I';
        final char malos_J1 = 'V';

        //Defino el tablero de juego, que es una matriz bidimensional
        char tablero[][] = new char[FILA_TABLERO][COLUMNA_TABLERO];

        //Voy a recorrer la matriz y a rellenarla completamente de "C"
        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                tablero[x][y] = relleno;

            }

        }

//He rellenado la matriz con 'C' desde el principio para que después sean los carácteres 
//que represeantan a los jugadores los que se sobreescriban a las 'L' y no alrevés.
//Ahora voy a repartir cinco 'I' que representan al jugador 1 (el indio) y también
//voy a repartir cinco 'V' que representan al jugador 2 (el vaquero).
//Todos en posiciones aleatorias.

        //*********PRIMERO INTRODUZCO LAS I (INDIOS)****************//
        
        //Defino las variables que corresponden a la posición del buenos_J1 (el indio) 
        //las cuales serán un número alearorio ,esto se hará 5 veces, puesto que quiero
        //repartir 5 indios.
        int x_jugador1 = 0;
        int y_jugador1 = 0;

        x_jugador1 = random.nextInt(tablero.length);
        y_jugador1 = random.nextInt(tablero[x_jugador1].length);

        tablero[x_jugador1][y_jugador1] = buenos_J1;

        //*********AHORA INTRODUZCO LAS V (VAQUEROS)****************//
        
        //Defino las variables que corresponden a la posición del malos_J1 (el vaquero) 
        //las cuales serán un número alearorio ,esto se hará 5 veces, puesto que quiero
        //repartir 5 vaqueros.
        while (contador_jugador2 != 5) {

            int x_jugador2 = 0;
            int y_jugador2 = 0;
            do {

                x_jugador2 = random.nextInt(tablero.length);
                y_jugador2 = random.nextInt(tablero[x_jugador2].length);

            } while (tablero[x_jugador2][y_jugador2] != 'C');

            tablero[x_jugador2][y_jugador2] = malos_J1;
            contador_jugador2++;

        }

        for (int fila = 0; fila < tablero.length; fila++) {

            System.out.println(" ");

            for (int columna = 0; columna < tablero[fila].length; columna++) {

                System.out.print(tablero[fila][columna] + " ");

            }

        }

        while (vidas > 0) {
            System.out.println(" ");

            //Ahora le pregunto al usuario en que dirección quiere moverse,para ello
            //deberá pulsar una letra del teclado,para cada dirección una letra
            System.out.println("¿En qué dirección quieres mover al indio?");
            respuesta = reader.next().charAt(0);

            //Ahora defino lo que ocurrirá dependiendo la tecla que pulse el usuario
            switch (Character.toUpperCase(respuesta)) {

                case 'W':
                    if (x_jugador1 - 1 >= 0) {
                        tablero[x_jugador1][y_jugador1] = 'C';
                        if (tablero[x_jugador1 - 1][y_jugador1] == 'V') {
                            vidas--;
                            tablero[x_jugador1 - 1][y_jugador1] = 'I';
                        } else {

                            tablero[x_jugador1 - 1][y_jugador1] = 'I';
                        }

                        x_jugador1--;

                    }

                    break;

                case 'S':
                    if (x_jugador1 + 1 >= 0) {
                        tablero[x_jugador1][y_jugador1] = 'C';
                        if (tablero[x_jugador1 + 1][y_jugador1] == 'V') {
                            vidas--;
                            tablero[x_jugador1 + 1][y_jugador1] = 'I';
                        } else {

                            tablero[x_jugador1 + 1][y_jugador1] = 'I';
                        }

                        x_jugador1++;

                    }

                    break;

                case 'D':
                    if (y_jugador1 + 1 >= 0) {
                        tablero[x_jugador1][y_jugador1] = 'C';
                        if (tablero[x_jugador1][y_jugador1 + 1] == 'V') {
                            vidas--;
                            tablero[x_jugador1][y_jugador1 + 1] = 'I';
                        } else {

                            tablero[x_jugador1][y_jugador1 + 1] = 'I';
                        }

                        y_jugador1++;

                    }
                    break;

                case 'A':
                    if (y_jugador1 - 1 >= 0) {
                        tablero[x_jugador1][y_jugador1] = 'C';
                        if (tablero[x_jugador1][y_jugador1 - 1] == 'V') {
                            vidas--;
                            tablero[x_jugador1][y_jugador1 - 1] = 'I';
                        } else {

                            tablero[x_jugador1][y_jugador1 - 1] = 'I';
                        }

                        y_jugador1--;

                    }
                    break;

                default:

            }

            for (int x = 0; x < tablero.length; x++) {

                System.out.println(" ");

                for (int y = 0; y < tablero[x].length; y++) {

                    System.out.print(tablero[x][y] + " ");

                }

            }

        }

    }
}
