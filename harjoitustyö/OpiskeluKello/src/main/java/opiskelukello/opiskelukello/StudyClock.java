package opiskelukello.opiskelukello;

import java.util.Scanner;
import studyclock.ui.timerUI;



/**
 *
 * @author mazaalto
 */

public class StudyClock {

    public static void main(String[] args) throws InterruptedException {
        Scanner lukija = new Scanner(System.in);
        Timer ajastin = new Timer();
        
        timerUI ui = new timerUI(lukija, ajastin);
        ui.start();


        

    }
}
