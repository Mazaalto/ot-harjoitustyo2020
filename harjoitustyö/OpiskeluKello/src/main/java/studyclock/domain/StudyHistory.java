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
    private Map<String, Integer> SubjectTimes;

    public StudyHistory() {
        this.SubjectTimes = new HashMap<>();
    }
    
    public void addStudyArea(String subject) {
        if (this.SubjectTimes.containsKey(subject)) {
            int previous = this.SubjectTimes.get(subject);
            //after studying we add a study time to record
            this.SubjectTimes.put(subject, previous+1);
        } else {
            this.SubjectTimes.put(subject, 1);
        }
    }
    public Integer getStudyTimeFromSubject(String subject) {
        if (this.SubjectTimes.containsKey(subject)) {
            return this.SubjectTimes.get(subject);
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String tostring = "";
        
        for (String key: SubjectTimes.keySet()) {
            String subject = "Opiskelit: " + key + " "+ Integer.toString(SubjectTimes.get(key))+ " kertaa \n";
            tostring += subject;
        }
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
