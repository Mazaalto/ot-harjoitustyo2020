package opiskelukello.opiskelukello;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author mazaalto
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {
        
        boolean timeLeft = true;
        long displayMinutes = 0;
        long starttime = System.currentTimeMillis();
        
        //going to add adjustable stoptime and also timestamp in the future, this is the starting point
        long stopTime = 1;
        
        System.out.println("Study Clock:");
        
        while (timeLeft) {
            TimeUnit.SECONDS.sleep(1);
            long timepassed = System.currentTimeMillis() - starttime;
            long displaySeconds = timepassed / 1000;
            
            
            if (displaySeconds == 60) {
                displaySeconds= 0;
                starttime = System.currentTimeMillis();
            }
            if ((displaySeconds % 60) == 0) {
                displayMinutes++;
                // if pomodorotimer is 25 minutes then stop
                if (displayMinutes == stopTime) {
                    timeLeft = false;
                }
            }

            System.out.println("Time passed: "+ displayMinutes + ":" + displaySeconds);

        }
        System.out.println("Congratulations! Have a brake now.");
    }
}
