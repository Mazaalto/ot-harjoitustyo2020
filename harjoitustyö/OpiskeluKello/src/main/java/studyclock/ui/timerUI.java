/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import studyclock.domain.Timer;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.stage.Stage;
import studyclock.domain.StudyHistory;

/**
 *
 * @author mazaalto
 */
public class timerUI {

    private Scanner reader;
    private Map<String, String> commands;
    private Timer timer;
    private StudyHistory history;

    public timerUI(Scanner reader, Timer clock) {
        this.reader = reader;
        timer = clock;

        commands = new TreeMap<>();
        commands.put("x", "x Stop");
        commands.put("1", "1 Set time in minutes");
        commands.put("2", "2 Choose a subject");
        commands.put("3", "3 Start the timer");
        commands.put("4", "4 Show the study history");
        commands.put("5", "5 Have a brake");

    }

    public void start() {
        System.out.println("The Study Timer");
        printInstructions();

        while (true) {
            System.out.println();
            System.out.print("command: ");
            String command = reader.nextLine();

            if (!commands.keySet().contains(command)) {
                System.out.println("The command is invalid.");

            }
            if (command.equals("x")) {
                break;

            } else if (command.equals("1")) {
                System.out.println("How many minutes will you study?");
                long time = Long.valueOf(reader.nextLine());
                this.timer.setTimeLeft(time);

            } else if (command.equals("3")) {
                this.timer.startClock();

            } else if (command.equals("2")) {
                System.out.println("What subject will you study?");
                String subj = reader.nextLine();
                this.history.addStudyArea(subj);

            } else if (command.equals("4")) {
                System.out.println("This is your study history:");
                String history = this.history.toString();

                //nyt tauko alkaa automaattisesti
            } else if (command.equals("5")) {
                System.out.println("How many minutes will you need for the break?");
                long time = Long.valueOf(reader.nextLine());
                this.timer.setTimeLeft(time);
                this.timer.startClock();
            }
        }
    }

    public void printInstructions() {
        System.out.println("Welcome to use the Study timer, these are the commands for the app: \n " + commands.values());
    }

//    public void start(Stage arg0) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
