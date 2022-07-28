package ej03guia4;
public class Carta {

private int valor;
private PalosCartas palo;

    public Carta() {
    }

    public Carta(int valor, PalosCartas palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public PalosCartas getPalo() {
        return palo;
    }

    public void setPalo(PalosCartas palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta: "+ valor + " de " + palo;
    }
    
}
