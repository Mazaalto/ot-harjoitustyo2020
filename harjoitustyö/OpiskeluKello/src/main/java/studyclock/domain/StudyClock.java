package studyclock.domain;

import static javafx.application.Application.launch;
import studyclock.ui.timerUIJavaFX;

/**
 * In this method the software begins by starting the UI in timerUIJava.FX
 * 
 */
public class StudyClock {

    public static void main(String[] args) throws InterruptedException {
        launch(timerUIJavaFX.class);
    }
}
