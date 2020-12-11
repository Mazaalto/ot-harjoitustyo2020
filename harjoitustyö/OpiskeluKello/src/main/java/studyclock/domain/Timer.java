package studyclock.domain;

/**
 *
 * @author mazaalto
 */
public class Timer {

    private int seconds;
    private String subject;

    public Timer(int seconds, String subject) {
        this.seconds = seconds;
        this.subject = subject;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getSubject() {
        return subject;
    }

}
