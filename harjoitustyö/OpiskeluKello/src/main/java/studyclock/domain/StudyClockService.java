/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.util.regex.Pattern;

/**
 *
 * @author mazaalto
 */
//ideana on siis se että täällä operoin sekunneilla, niin että tallennan oikeat sekunti määrät
//ja aiheet studyhistoryyn, lisäksi täältä operoin sitten historian välittymisen rapsa osioon
//silloin ajattelin tallentaa tiedon tekstitiedostoon, josta teen sitten ArrayListan luettaessa
//luku tapahtuu täällä
public class StudyClockService {

    private StudyHistory history;

    public StudyClockService() {
        this.history = new StudyHistory();

    }

    //gets string as a parameter, return value if possible else -1
    public int getStringToInt(String fromUI) {
        int valueInMinutes = 0;
        if (checkIfInt(fromUI)) {
            valueInMinutes = Integer.parseInt(fromUI);
            return valueInMinutes;
        }
        return -1;
    }

    public StudyHistory getHistory() {
        return history;
    }

    public void addTimer(Timer timer) {
        this.history.addTimerToList(timer);

    }

    public Timer getTimerFromHistory() {
        return this.history.getTimer();

    }

    public boolean checkIfInt(String something) {
        Pattern intPattern = Pattern.compile("\\d+");
        if (something == null) {
            return false;
        }
        return intPattern.matcher(something).matches();

    }

}
