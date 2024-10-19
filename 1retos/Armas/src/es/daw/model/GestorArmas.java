package es.daw.model;

import java.util.ArrayList;

public class GestorArmas {
    private ArrayList<Arma> armas;

    public GestorArmas() {
        armas = new ArrayList<>();
    }

    public void addArma(Arma arma) {
        armas.add(arma);
    }

    public void removeArma() {// por que no tengo que pasar el arma en remove arma
        if (armas.size() > 0) {
            armas.remove(armas.size() - 1);
        } else {
            System.out.println("No hay armas!!");
        }
    }

    @Override
    public String toString() {
        return "GestorArmas [armas=" + armas + "]";
    }

}