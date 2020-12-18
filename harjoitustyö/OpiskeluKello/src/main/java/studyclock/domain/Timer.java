package studyclock.domain;

/**
 * Studying times are stored as timers in the StudyHistory class
 *
 *
 */
public class Timer {

    private int minutes;
    private String subject;
    String date;

    /**
     * This method constructs a timer
     *
     * @param minutes is the studied time in minutes
     * @param subject is the studied subject as a string
     * @param date is the date of the studied time Tue Dec 15 13:09:18 EET 2020
     */
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

    /**
     * Method returns the timer in a String to be saved in a file
     *
     * @return toFile timer as a String separeted with ; between data points
     */
    public String timerToString() {
        String toFile = this.minutes + ";" + this.subject + ";" + this.date;
        return toFile;
    }

}
