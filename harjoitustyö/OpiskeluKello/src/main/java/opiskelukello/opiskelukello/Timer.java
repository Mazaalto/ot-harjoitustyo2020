 
package opiskelukello.opiskelukello;

/**
 *
 * @author mazaalto
 */
public class Timer {
    private long timeLeft;
    
    public Timer(long stopTime) {
        this.timeLeft = stopTime;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }
    
     
    
}
