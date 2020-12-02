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

    public Map<String, Integer> getSubjectTimes() {
        return subjectTimes;
    }

    public void addStudyArea(String subject, int time) {
        if (this.subjectTimes.containsKey(subject)) {
            int previousTime = this.subjectTimes.get(subject);
            //after studying we add a study time to record
            this.subjectTimes.put(subject, previousTime + time);
        } else {
            this.subjectTimes.put(subject, time);
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
