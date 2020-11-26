/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import studyclock.domain.Timer;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.stage.Stage;
import studyclock.domain.StudyHistory;

/**
 *
 * @author mazaalto
 */
public class timerUI {

    private Scanner lukija;
    private Map<String, String> komennot;
    private Timer ajastin;
    private StudyHistory history;

    public timerUI(Scanner lukija, Timer kello) {
        this.lukija = lukija;
        ajastin = kello;
        //testaan voiko kello saada lukija, jotta x painaessa se pysähtyy

        komennot = new TreeMap<>();
        komennot.put("x", "x lopeta");
        komennot.put("1", "1 aseta opiskeluaika minuuteissa");
        komennot.put("2", "2 valitse aihe");
        komennot.put("3", "3 käynnistä kello");
        komennot.put("4", "4 Näytä historia");

//      komennot.put("3", "3 pysäytä kello");
//      komennot.put("4", "4 montako kertaa toistetaan ennen pidempää taukoa?");
//      komennot.put("5", "5 aseta tauon pituus");
    }

    public void start() {
        System.out.println("Opiskelukello");
        printInstructions();

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
                System.out.println("Syötä aika minuuteissa");
                long aika = Long.valueOf(lukija.nextLine());
                this.ajastin.setTimeLeft(aika);

            } else if (komento.equals("3")) {
                this.ajastin.startTheClock();

            } else if (komento.equals("2")) {
                System.out.println("Mitä aihetta aiot opiskella?");
                String aihe = lukija.nextLine();
                this.history.addStudyArea(aihe);

            } else if (komento.equals("4")) {
                System.out.println("Opiskeluhistoriasi:");
                String historia = this.history.toString();
            }

        }
    }

    public void printInstructions() {
        System.out.println("käytettävissä olevat komennot: " + komennot.values());
    }

//    public void start(Stage arg0) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
