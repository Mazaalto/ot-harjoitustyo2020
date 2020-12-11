/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.util.ArrayList;

/**
 *
 * @author mazaalto
 */
public class StudyHistory {

    private ArrayList<Timer> list;

    public StudyHistory() {
        this.list = new ArrayList<>();
    }

    public void addTimerToList(Timer timer) {
        this.list.add(timer);

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
