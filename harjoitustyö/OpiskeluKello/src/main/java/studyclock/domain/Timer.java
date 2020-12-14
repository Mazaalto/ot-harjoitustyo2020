package studyclock.domain;

/**
 * Studying times are stored as timers in the StudyHistory class
 * @author mazaalto
 */
public class Timer {

    private int minutes;
    private String subject;

    public Timer(int minutes, String subject) {
        this.minutes = minutes;
        this.subject = subject;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

}
