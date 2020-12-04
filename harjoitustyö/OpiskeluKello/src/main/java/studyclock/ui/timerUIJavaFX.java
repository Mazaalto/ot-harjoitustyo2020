/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import studyclock.domain.StudyHistory;
import studyclock.domain.Timer;

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    private Map<String, String> commands;
    private Timer timer;
    private StudyHistory history;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");

        //starting the commands
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        Button buttonA = new Button("Set time in minutes");
        Button buttonB = new Button("Start the timer");
        Button buttonC = new Button("Show the study history");
        Button buttonD = new Button("Have a brake");

        //GridPane components = new GridPane();
        buttons.getChildren().add(buttonA);
        buttons.getChildren().add(buttonB);
        buttons.getChildren().add(buttonC);
        buttons.getChildren().add(buttonD);

        //Scenes
        Scene first = new Scene(buttons);

        //Scene in Set time in minutes
        Button backToStart = new Button("go back");
        HBox buttonsSetTime = new HBox();
        buttonsSetTime.setSpacing(15);
        buttonsSetTime.getChildren().add(backToStart);
        Label text = new Label("Here you can choose how many minutes you want to study");
        buttonsSetTime.getChildren().add(text);
        Scene second = new Scene(buttonsSetTime);

        //Scene where is the analytics
        Button backToStartAnalytics = new Button("go back");
        HBox buttonsAnalytics = new HBox();
        buttonsAnalytics.setSpacing(15);
        buttonsAnalytics.getChildren().add(backToStartAnalytics);
        Label text2 = new Label("Here you will see your study history");
        buttonsAnalytics.getChildren().add(text2);
        Scene third = new Scene(buttonsAnalytics);

        //Scene where you can have a brake
        Button backFromBrake = new Button("go back");
        HBox buttonsBrake = new HBox();
        buttonsBrake.setSpacing(15);
        buttonsBrake.getChildren().add(backFromBrake);
        Label text3 = new Label("Here you can have a relaxing brake");
        buttonsBrake.getChildren().add(text3);
        Scene four = new Scene(buttonsBrake);

        //functionalities of the buttons of main scene
        buttonA.setOnAction((event) -> {
            System.out.println("Going to the time adjusment window");
            window.setScene(second);

        });
        buttonB.setOnAction((event) -> {
            System.out.println("Starting the timer");
            window.setScene(first);

        });
        buttonC.setOnAction((event) -> {
            System.out.println("Show the study history");
            window.setScene(third);

        });
        buttonD.setOnAction((event) -> {
            System.out.println("Have a brake");
            window.setScene(four);

        });

        //functionalities of the buttons of Set time in minutes scene
        backToStart.setOnAction((event) -> {
            System.out.println("Going to the starting window");
            window.setScene(first);

        });
        //functionalities of the buttons of analytics
        backToStartAnalytics.setOnAction((event) -> {
            System.out.println("Going to the starting window");
            window.setScene(first);

        });
        //functionalities of the buttons of brake window
        backFromBrake.setOnAction((event) -> {
            System.out.println("Going to the starting window");
            window.setScene(first);

        });
        
        
        

        //here will be the scene for study analytics
        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(timerUIJavaFX.class);
    }

}
