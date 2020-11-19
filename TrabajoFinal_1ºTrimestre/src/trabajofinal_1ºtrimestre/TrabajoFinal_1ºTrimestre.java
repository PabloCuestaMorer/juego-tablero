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
        final int LARGO_TABLERO = 5;
        final int ANCHO_TABLERO = 5;
        //Defino las variable correspondientes a los jugadores y a los espacios vacíos
        final char icoRelleno = 'C';
        final char icoBuenos = 'I';
        final char icoMalos = 'V';
        int vidas = 3;
        //Defino las variables correspondientes a las coordenadas del personaje
        //bueno
//        int x_bueno = 0;
//        int y_bueno = 0;
        //Defino el tablero de juego, que es una matriz bidimensional
        char tablero[][] = new char[LARGO_TABLERO][ANCHO_TABLERO];
        //Inicio tablero
        int[] coordenadas_bueno = iniciarTablero(tablero, icoRelleno, icoBuenos, icoMalos);
        //Muestro el tablero ya totalmente completo y funcional
        mostrarTablero(tablero);
        //Pregunto al usuario en que dirección quiere mover a su personaje 
        while (vidas > 0) {
            mostrarTablero(movimiento(tablero, vidas, icoBuenos, coordenadas_bueno[0], coordenadas_bueno[1]));
        }
    }

    /**
     * Inicia el tablero,lo rellena y asigna los personajes en posiciones
     * aleatorias sin sobreescribirse unos a otros
     *
     * @param tablero
     * @param icoRellenos
     * @param icoBuenos
     * @param icoMalos
     * @return char [][]
     */
    public static int[] iniciarTablero(char[][] tablero, char icoRellenos, char icoBuenos, char icoMalos) {

        //Rellenamos tablero
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                tablero[x][y] = icoRellenos;
            }
        }

        //Insertar personajes
        Random random = new Random();
        int[]coordenadas_bueno = {random.nextInt(tablero.length),random.nextInt(tablero.length)};
        tablero[coordenadas_bueno[0]][coordenadas_bueno[1]] = icoBuenos;

        int contadorMalos = 0;
        while (contadorMalos < 5) {
            int x = random.nextInt(tablero.length);
            int y = random.nextInt(tablero.length);
            if (tablero[x][y] == icoRellenos) {
                tablero[x][y] = icoMalos;
                contadorMalos++;
            }
        }

        return coordenadas_bueno;
    }

    /**
     * Muestra el tablero por consola.
     *
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

    /**
     *
     * @param tablero
     * @param letraMovimiento
     * @param vidas
     * @param respuesta
     * @param icoBuenos
     * @param x_bueno
     * @param y_bueno
     */
    public static char[][] movimiento(char[][] tablero, int vidas, char icoBuenos, int x_bueno, int y_bueno) {

        Scanner reader = new Scanner(System.in);

        System.out.print("\n¿En qué dirección quieres mover al indio? : ");
        char teclaMovimiento = reader.next().charAt(0);

        switch (Character.toUpperCase(teclaMovimiento)) {
            case 'W':
                if (x_bueno - 1 >= 0) {
                    tablero[x_bueno][y_bueno] = 'C';
                    tablero[x_bueno - 1][y_bueno] = 'I';
                    if (tablero[x_bueno - 1][y_bueno] == 'V') {
                        vidas--;
                    }
                    x_bueno--;
                    
                }
                break;

            case 'S':
                if (x_bueno + 1 >= 0) {
                    tablero[x_bueno][y_bueno] = 'C';
                    tablero[x_bueno + 1][y_bueno] = 'I';
                    if (tablero[x_bueno + 1][y_bueno] == 'V') {
                        vidas--;
                    }
                    x_bueno++;
                }
                break;

            case 'D':
                if (y_bueno + 1 >= 0) {
                    tablero[x_bueno][y_bueno] = 'C';
                    tablero[x_bueno][y_bueno + 1] = 'I';
                    if (tablero[x_bueno][y_bueno + 1] == 'V') {
                        vidas--;
                    }
                    y_bueno++;
                }
                break;

            case 'A':
                if (y_bueno - 1 >= 0) {
                    tablero[x_bueno][y_bueno] = 'C';
                    tablero[x_bueno][y_bueno - 1] = 'I';
                    if (tablero[x_bueno][y_bueno - 1] == 'V') {
                        vidas--;
                    }
                    y_bueno--;
                }
                break;
            default:
                System.out.println("Pulse una de las teclas de movimiento: W A S D.");
            break;
        }

        return tablero;
    }

}
