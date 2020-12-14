
package studyclock.domain;

import java.util.ArrayList;

/**
 * The timers are stored as StudyHistory objects
 * @author mazaalto
 */
public class StudyHistory {

    private ArrayList<Timer> list;

    public StudyHistory() {
        this.list = new ArrayList<>();
    }

    public void addTimerToList(int minutes, String subject) {
        Timer brandNew = new Timer(minutes, subject);
        this.list.add(brandNew);

    }

    public Timer getTimer() {
        if (!list.isEmpty()) {
            int size = this.list.size();
            return this.list.get(size - 1);
        }
        return null;
    }

    public ArrayList<Timer> getList() {
        return list;
    }

    public int getListSize() {
        return this.list.size();
    }

}
