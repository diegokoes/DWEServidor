package es.daw;

import es.daw.model.Arco;
import es.daw.model.Arma;
import es.daw.model.EspadaAcero;
import es.daw.model.EspadaHielo;
import es.daw.model.GestorArmas;

public class App {

  public static void main(String[] args) throws Exception {

    GestorArmas gestor = new GestorArmas();

    gestor.addArma(new EspadaAcero("Espada de acero inoxidable", 100, true));
    gestor.addArma(new EspadaHielo("Espada de hielo polar", 50, false));
    gestor.addArma(new Arco("Arco olímpico", 75, 125.5f));
    gestor.addArma(new Arco("Arco pocho", 0));

    System.out.println("\n* Número de armas creadas:" + Arma.getContador());

    System.out.println("\n* Listado de armas:");
    System.out.println(gestor);

    gestor.removeArma();

    System.out.println("\n* Listado después de borrar todas las armas:");
    System.out.println(gestor);

  }
}