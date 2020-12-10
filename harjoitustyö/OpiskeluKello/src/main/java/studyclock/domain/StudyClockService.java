/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.applet.AudioClip;
import java.util.Timer;
import java.util.TimerTask;

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
//        this.timer.schedule(new TimerTask() {
//            @Override
//            AudioClip myClip = new AudioClip(getClass().getClassloader()
//                    .getResource("Bell.mp3").toString()) {
//                @Override
//                public void play() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void loop() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void stop() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            };
//
//            myClip.play ();
//        }
        

    }

//    public void starTheTimer(JLabel label) throws InterruptedException {
//        this.timer.startClock(label);
//    }

    public void setSubjectToStudy(String subject) {
        this.history.addStudyArea(subject, 0);
    }

    public Integer getStudyTimeFromSubject(String subject) {
        return this.history.getStudyTimeFromSubject(subject);
    }
}
