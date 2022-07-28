package ej03guia4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Baraja {

    private ArrayList<Carta> cartas = new ArrayList<>();
    private ArrayList<Carta> montonCartas = new ArrayList<>();

    public Baraja() {
    }

    public void setMontonCartas(ArrayList<Carta> montonCartas) {
        this.montonCartas = montonCartas;
    }

    public ArrayList<Carta> getMontonCartas() {
        return montonCartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Baraja: " + "cartas:" + cartas + '}';
    }

    public void barajar() {
        System.out.println("Se baraja el mazo");
        Collections.shuffle(cartas);
    }

    public void siguienteCarta() {
        Iterator it = cartas.iterator();
        Carta aux = new Carta();
        if (cartasDisponibles() == 0) {
            System.out.println("No quedan cartas en la baraja");
        } else if (it.hasNext()) {
            if (cartasDisponibles() == 1) {
                System.out.println("Se dio la ultima carta");
                montonCartas.add((Carta) it.next());
                cartas.remove(aux);
            } else {
                aux = (Carta) it.next();
                System.out.println("Se pone la carta " + aux + " en el monton");
                cartas.remove(aux);
                montonCartas.add(aux);
            }

        }
    }

    public int cartasDisponibles() {
        return 40 - montonCartas.size();
    }

    public void darCartas(int n) {
        if (n > cartasDisponibles()) {
            System.out.println("No hay suficientes cartas en la baraja.");
        } else {
            for (int i = 0; i < n; i++) {
                siguienteCarta();
            }
        }
    }

    public String cartasMonton() {
        System.out.println("Hasta el momento se han pedido: " + montonCartas.size() + " cartas");
        System.out.println("Quedan disponibles: " + cartasDisponibles() + " cartas");
        return "Cartas del monton: " + montonCartas.toString();
    }

    public void mostrarBaraja() {
        if (cartasDisponibles() == 0) {
            System.out.println("No quedan cartas en la baraja");
        } else {
            System.out.println("Cartas restantes en la baraja: ");
            System.out.println(cartas.toString());
        }
    }
}
