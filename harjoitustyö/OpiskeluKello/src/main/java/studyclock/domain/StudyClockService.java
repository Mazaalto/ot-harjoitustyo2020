/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.util.regex.Pattern;

/**
 * This class has all the logic that is operated in the UI (timerUIJavaFX)
 *
 * @author mazaalto
 */
//ideana on siis se että täällä operoin sekunneilla, niin että tallennan oikeat sekunti määrät
//ja aiheet studyhistoryyn, lisäksi täältä operoin sitten historian välittymisen rapsa osioon
//silloin ajattelin tallentaa tiedon tekstitiedostoon, josta teen sitten ArrayListan luettaessa
//luku tapahtuu täällä
public class StudyClockService {

    private StudyHistory history;
    private int seconds;
    private String unknownSubj;
    private String type;
    private int goalHours;

    public StudyClockService() {
        this.history = new StudyHistory();
        this.unknownSubj = "not set";
        this.seconds = 1500;
        this.type = "study";

    }

    public int getGoal() {
        return goalHours;
    }

    public void setGoal(int goal) {
        this.goalHours = goal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public StudyHistory getHistory() {
        return this.history;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getUnknownSubj() {
        return unknownSubj;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setSubject(String unknownSubj) {
        this.unknownSubj = unknownSubj;
    }

    //Here we can check if String can be converted to integer
    public boolean checkIfInt(String something) {
        Pattern intPattern = Pattern.compile("\\d+");
        if (something == null) {
            return false;
        }
        return intPattern.matcher(something).matches();

    }

    //gets string as a parameter, return value in int if possible, else -1
    public int getStringToInt(String fromUI) {
        int valueInMinutes = 0;
        if (checkIfInt(fromUI)) {
            valueInMinutes = Integer.parseInt(fromUI);
            return valueInMinutes;
        }
        return -1;
    }

    //seconds are changed to minutes when they are saved to studyhistory
    public void addTimer() {
        int minutes = this.seconds / 60;
        this.history.addTimerToList(minutes, this.unknownSubj);

    }

    public Timer getTimerFromHistory() {
        return this.history.getTimer();

    }

    public void minusSeconds() {
        this.seconds = this.seconds - 1;
    }

}
