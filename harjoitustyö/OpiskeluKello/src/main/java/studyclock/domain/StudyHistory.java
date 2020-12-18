package studyclock.domain;

import java.util.ArrayList;

/**
 * The timers are stored as StudyHistory objects
 *
 * 
 */
public class StudyHistory {

    private ArrayList<Timer> list;

    public StudyHistory() {
        this.list = new ArrayList<>();
    }

    /**
     * Method adds a timer to list
     *
     * @param minutes is the minutes to timer
     * @param subject is the studied subject
     * @param date is the date as a string
     * 
     */
    public void addTimerToList(int minutes, String subject, String date) {
        Timer brandNew = new Timer(minutes, subject, date);
        this.list.add(brandNew);

    }

    /**
     * Method gives the most current timer
     *
     * @return timer if there is one else null 
     */
    public Timer getTimer() {
        if (!list.isEmpty()) {
            int size = this.list.size();
            return this.list.get(size - 1);
        }
        return null;
    }

    /**
     * Method returns the list
     *
     * @return list is the list of the timers 
     */
    public ArrayList<Timer> getList() {
        return list;
    }

    /**
     * Method returns the size of the list
     *
     * @return size
     */
    public int getListSize() {
        return this.list.size();
    }

}
