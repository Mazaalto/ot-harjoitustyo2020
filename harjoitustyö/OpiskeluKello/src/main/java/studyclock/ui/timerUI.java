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
        this.history = new StudyHistory();

        commands = new TreeMap<>();
        commands.put("x", "x Stop");
        commands.put("1", "1 Set time in minutes");
        commands.put("2", "2 Start the timer");
        commands.put("3", "3 Show the study history");
        commands.put("4", "4 Have a brake");

    }

    public void start() throws InterruptedException {
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
                this.timer.setIsThereTimeToFalse();
                break;

            } else if (command.equals("1")) {
                System.out.println("How many minutes will you study?");
                long time = Long.valueOf(reader.nextLine());
                System.out.println("What subject will you study?");
                this.timer.setTimeLeft(time);
                String subj = reader.nextLine();
                int timeInt = (int) time;
                this.history.addStudyArea(subj, timeInt);

                System.out.println("Start the timer by pressing 2");

            } else if (command.equals("2")) {
                this.timer.startClock();

            } else if (command.equals("3")) {
                System.out.println("This is your study history:");
                String history = this.history.toString();
                System.out.println(history);

                //nyt tauko alkaa automaattisesti
            } else if (command.equals("4")) {
                System.out.println("How many minutes will you need for the break?");
                long time = Long.valueOf(reader.nextLine());
                this.timer.setTimeLeft(time);
                this.timer.startClock();
            } else {
                System.out.println("Command was invalid");
                continue;
            }
        }
    }

    public void printInstructions() {
        System.out.println("Welcome to use the Study timer, these are the commands for the app: \n " + commands.values());
    }

//    
}
