package studyclock.domain;

import java.util.ArrayList;

/**
 * The timers are stored as StudyHistory objects
 *
 * @author mazaalto
 */
public class StudyHistory {

    private ArrayList<Timer> list;

    public StudyHistory() {
        this.list = new ArrayList<>();
    }

    /**
     * This adds a timer to list
     *
     * @param minutes is the minutes to timer
     * @param subject is the studied subject
     * @param date is the date as a string
     * @author mazaalto
     */
    public void addTimerToList(int minutes, String subject, String date) {
        Timer brandNew = new Timer(minutes, subject, date);
        this.list.add(brandNew);

    }

    /**
     * This method gives the most current timer
     *
     * @return timer if there is one else null
     * @author mazaalto
     */
    public Timer getTimer() {
        if (!list.isEmpty()) {
            int size = this.list.size();
            return this.list.get(size - 1);
        }
        return null;
    }

    /**
     * This method returns the list
     *
     * @return list is the list of the timers
     * @author mazaalto
     */
    public ArrayList<Timer> getList() {
        return list;
    }

    /**
     * This method returns the size of the list
     *
     * @return size
     * @author mazaalto
     */
    public int getListSize() {
        return this.list.size();
    }

}
