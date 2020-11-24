package opiskelukello.opiskelukello;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mazaalto
 */
public class Timer {

    private boolean isThereTime;
    private long displayMinutes;
    private long starttime;
    private long timeLeft;

    public Timer() {
        this.isThereTime = true;
        this.displayMinutes = 0;

    }

    //when the timer reach stoptime, there is a break
    public void setTimeLeft(long timeLeft) {
        if (timeLeft >= 0) {
            this.timeLeft = timeLeft;
        }
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void startTheClock() {

        this.starttime = System.currentTimeMillis();

        while (isThereTime) {

            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }

            long timepassed = System.currentTimeMillis() - this.starttime;
            long displaySeconds = timepassed / 1000;

            if (displaySeconds == 60) {
                displaySeconds = 0;
                starttime = System.currentTimeMillis();
            }
            if ((displaySeconds % 60) == 0) {
                displayMinutes++;
                // if pomodoro timer is 25 minutes then stop
                if (displayMinutes == timeLeft) {
                    this.isThereTime = false;
                }
            }

            System.out.println("Time passed: " + displayMinutes + ":" + displaySeconds);
        }
        System.out.println("Congratulations! Have a brake now.");
    }

}
