/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

/**
 *
 * @author mazaalto
 */
public class StudyClockService {

    private Timer timer;
    private StudyHistory history;

    public StudyClockService() {
        //this.reader = reader;
        this.timer = new Timer();
        this.history = new StudyHistory();

    }

    public void setTimeInMinutes(long minutes) {
        this.timer.setTimeLeft(minutes);
    }

    public void setSubjectToStudy(String subject) {
        this.history.addStudyArea(subject, 0);
    }

    public Integer getStudyTimeFromSubject(String subject) {
        return this.history.getStudyTimeFromSubject(subject);
    }
}
