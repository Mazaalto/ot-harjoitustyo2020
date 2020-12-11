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
//ideana on siis se että täällä operoin sekunneilla, niin että tallennan oikeat sekunti määrät
//ja aiheet studyhistoryyn, lisäksi täältä operoin sitten historian välittymisen rapsa osioon
//silloin ajattelin tallentaa tiedon tekstitiedostoon, josta teen sitten ArrayListan luettaessa
//luku tapahtuu täällä
public class StudyClockService {

    private StudyHistory history;

    public StudyClockService() {

        this.history = new StudyHistory();

    }

    public StudyHistory getHistory() {
        return history;
    }

    public void addTimer(Timer timer) {
        this.history.addTimerToList(timer);

    }

}
