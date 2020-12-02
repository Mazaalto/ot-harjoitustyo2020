package studyclock.domain;

import java.util.Scanner;
import static javafx.application.Application.launch;
import studyclock.ui.timerUI;

/**
 *
 * @author mazaalto
 */
public class StudyClock {

    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        Timer timer = new Timer();

        timerUI ui = new timerUI(reader, timer);
        ui.start();

    }
}
