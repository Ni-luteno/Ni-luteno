/* Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número
entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta
clase debe contener un método toString() que retorne el número de carta y el palo. La
baraja estará compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya
más o se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número
de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos
nada, pero debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario. 
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta
y luego se llama al método, este no mostrara esa primera carta.
 */
package ej03guia4;

import java.util.Scanner;

public class Ej03Guia4 {

    public static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        Baraja b = new Baraja();
        b = crearBaraja(b);

        System.out.println("Bienvenido al sinoca.");
        boolean sale = false;
        do {
            System.out.println("¿Que desea hacer?");
            System.out.println("1 - Mostrar baraja");
            System.out.println("2 - Mostrar monton de cartas");
            System.out.println("3 - Barajar");
            System.out.println("4 - Pedir siguiente carta");
            System.out.println("5 - Pedir cartas (varias)");
            System.out.println("6 - Salir");
            int opc = leer.nextInt();
            switch (opc) {
                case 1:
                    b.mostrarBaraja();
                    break;
                case 2:
                    System.out.println(b.cartasMonton());
                    break;
                case 3:
                    b.barajar();
                    break;
                case 4:
                    b.siguienteCarta();
                    break;
                case 5:
                    System.out.println("¿Cuantas cartas pide?");
                    b.darCartas(leer.nextInt());
                    break;
                case 6:
                    sale = true;
                    break;
                default:
                    System.out.println("Ingrese una de las opciones indicadas");
            }
        } while (!sale);
    }

//Crea baraja llenando palo por palo.
    public static Baraja crearBaraja(Baraja b) {

        llenarConPalo(b, PalosCartas.BASTO);
        llenarConPalo(b, PalosCartas.ORO);
        llenarConPalo(b, PalosCartas.COPA);
        llenarConPalo(b, PalosCartas.ESPADA);
        return b;
    }
//Ingresa todas las cartas del 1 al 12 (evitando 8 y 9), del palo indicado a la baraja indicada.

    public static void llenarConPalo(Baraja b, PalosCartas palo) {
        for (int i = 1; i < 13; i++) {
            Carta aux = new Carta(i, palo);
            if (i == 8 || i == 9) {
            } else {
                b.getCartas().add(aux);
            }
        }
    }

}
