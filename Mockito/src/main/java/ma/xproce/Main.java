package ma.xproce;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        IForme cercle = new Cercle(4.0);
        IForme rectangle = new Rectangle(2.0, 4.0);

        List<IForme> formes = Arrays.asList(cercle, rectangle);

        double aireTotale = CalculatriceAire.aire(formes);

        System.out.println("Aire totale des formes : " + aireTotale);

    }

}
