/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opiskelukello.opiskelukello;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author mazaalto
 */
public class timerUI {

    private Scanner lukija;
    private Map<String, String> komennot;
    private Timer ajastin;

    public timerUI(Scanner lukija) {
        this.lukija = lukija;
        ajastin = new Timer();

        komennot = new TreeMap<>();

        komennot.put("x", "x lopeta");
        komennot.put("1", "1 aseta opiskeluaika");
        komennot.put("2", "2 pysäytä kello");
        komennot.put("3", "3 lisää aihe");
        komennot.put("4", "4 montako kertaa toistetaan ennen pidempää taukoa?");
        komennot.put("5", "5 aseta tauon pituus");
    }

    public void kaynnista() {
        System.out.println("Opiskelukello");

        while (true) {
            System.out.println();
            System.out.print("komento: ");
            String komento = lukija.nextLine();
            if (!komennot.keySet().contains(komento)) {
                System.out.println("virheellinen komento.");

            }

            if (komento.equals("x")) {
                break;
            } else if (komento.equals("1")) {
                //ajastin.setTimeLeft(0);
            } else if (komento.equals("2")) {
                //haeNumerot();
            } else if (komento.equals("3")) {
                //haeHenkilo();
            }
        }
    }
}

//    private void haeNumerot() {
//        System.out.print("kenen: ");
//        String nimi = lukija.nextLine();
//       // Collection<String> numerot = palvelu.haeNumerot(nimi);
//        if (numerot.isEmpty()) {
//            System.out.println("  ei löytynyt");
//            return;
//        }
//
//        for (String numero : numerot) {
//            System.out.println(" " + numero);
//        }
//    }
//
//    private void lisaaNumero() {
//        System.out.print("kenelle: ");
//        String nimi = lukija.nextLine();
//        System.out.print("numero: ");
//        String numero = lukija.nextLine();
//        //palvelu.lisaaNumero(nimi, numero);
//    }
//
//    // lisää käyttöliittymäfunktioita...
//}
