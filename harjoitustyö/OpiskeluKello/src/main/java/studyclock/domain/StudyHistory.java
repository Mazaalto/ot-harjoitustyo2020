/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mazaalto
 */
public class StudyHistory {

    private Map<String, Integer> subjectTimes;

    public StudyHistory() {
        this.subjectTimes = new HashMap<>();
    }

    public void addStudyArea(String subject) {
        if (this.subjectTimes.containsKey(subject)) {
            int previous = this.subjectTimes.get(subject);
            //after studying we add a study time to record
            this.subjectTimes.put(subject, previous + 1);
        } else {
            this.subjectTimes.put(subject, 1);
        }
    }

    public Integer getStudyTimeFromSubject(String subject) {
        if (this.subjectTimes.containsKey(subject)) {
            return this.subjectTimes.get(subject);
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String tostring = "";

        for (String key : subjectTimes.keySet()) {
            String subject = "You studied: " + key + " " + Integer.toString(subjectTimes.get(key)) + " times \n";
            tostring += subject;
        }
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
