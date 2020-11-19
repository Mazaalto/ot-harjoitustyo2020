package opiskelukello.opiskelukello;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author mazaalto
 */

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Scanner lukija = new Scanner(System.in);
        Timer ajastin = new Timer();
        
        timerUI ui = new timerUI(lukija, ajastin);
        ui.start();


        

    }
}
