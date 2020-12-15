package studyclock.domain;

/**
 * Studying times are stored as timers in the StudyHistory class
 * @author mazaalto
 */
public class Timer {

    private int minutes;
    private String subject;
    String date;
    //Tue Dec 15 13:09:18 EET 2020 date is stored like this
    public Timer(int minutes, String subject, String date) {
        this.minutes = minutes;
        this.subject = subject;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
