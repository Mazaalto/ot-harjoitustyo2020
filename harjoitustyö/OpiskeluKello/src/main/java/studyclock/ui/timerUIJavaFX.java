/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import studyclock.domain.StudyClockService;
import studyclock.domain.Timer;

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    private int starttimeSeconds = 20;
    private int starttimeMinutes = 1;
    private int minutes;
    private int seconds;
    private Timeline timeline;
    private Label timerLabelMinutes = new Label("00");
    private Label timerLabelSeconds = new Label("00");
    private Label middle = new Label(":");

//    private IntegerProperty timeInSeconds = new SimpleIntegerProperty(starttimeSeconds);
//    private IntegerProperty timeInMinutes = new SimpleIntegerProperty(starttimeMinutes);
    private StudyClockService service;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");

        seconds = 65;
        this.minutes = 1;

        //Here is the logic of the app
        StudyClockService service = new StudyClockService();

        //starting the commands
        BorderPane mainScene = new BorderPane();

        Button buttonA = new Button("Set time in minutes");
        Button buttonB = new Button("Start the timer");
        Button buttonC = new Button("Show the study history");
        Button buttonD = new Button("Have a break");

        HBox buttons = new HBox();
        buttons.setSpacing(180);
        buttons.getChildren().add(buttonA);
        buttons.getChildren().add(buttonB);
        buttons.getChildren().add(buttonC);
        buttons.getChildren().add(buttonD);

        mainScene.setTop(buttons);
        mainScene.setLeft(timerLabelMinutes);
        mainScene.setRight(timerLabelSeconds);
        mainScene.setCenter(middle);

        //Scenes
        Scene first = new Scene(mainScene);
        //Get the time to study from user (esim textboxista)

        //testi timerin näytölle
        timerLabelMinutes.setTextFill(Color.AQUAMARINE);
        timerLabelSeconds.setTextFill(Color.ORANGERED);

//      timerLabel.textProperty().bind(timeInMinutes.asString());
//      timerLabel2.textProperty().bind(timeInSeconds.asString());
        timerLabelMinutes.setStyle("-fx-font-size: 30em;");
        timerLabelSeconds.setStyle("-fx-font-size: 30em;");
        middle.setStyle("-fx-font-size: 15em;");

        //set The Audioclip for completing pomodoro
        //AudioClip money = new AudioClip("file:moneyInTheBank.wav");
        //Scene in Set time in minutes
        VBox buttonsSetTime = new VBox();
        Button setTime = new Button("Set time");
        Button backToStart = new Button("go back");
        Label instructions = new Label("Here you can write in minutes how long will you study before break");
        TextField minutesInText = new TextField();
        buttonsSetTime.setSpacing(15);
        buttonsSetTime.getChildren().add(instructions);
        buttonsSetTime.getChildren().add(minutesInText);
        buttonsSetTime.getChildren().add(setTime);
        buttonsSetTime.getChildren().add(backToStart);

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
        VBox buttonsBreak = new VBox();
        Button setTimeForBeak = new Button("Set time for break");
        Button backFromBrake = new Button("go back");
        Label instructionsOfBreak = new Label("Here you can set the time for the break");
        TextField minutesInTextBreak = new TextField();
        buttonsBreak.setSpacing(15);
        buttonsBreak.getChildren().add(instructions);
        buttonsBreak.getChildren().add(minutesInText);
        buttonsBreak.getChildren().add(setTime);
        buttonsBreak.getChildren().add(backToStart);
        Scene four = new Scene(buttonsBreak);

        //functionalities of the buttons of main scene
        buttonA.setOnAction((event) -> {
            System.out.println("Going to the time adjusment window");
            window.setScene(second);

        });

        //starting the timer in the mainScene from start button
        buttonB.setOnAction((event) -> {
            System.out.println("Starting the timer");

            if (timeline != null) {
                timeline.stop();
            }
            //tähän tee minuutit kanssa näkyviin minuutit:sekunnit tyylillä
//            timeInMinutes.set(starttimeMinutes);
//            timeInSeconds.set(starttimeSeconds);

            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(1), (ActionEvent event1) -> {
                        seconds--;

                        // update timerLabels minutes and seconds
                        timerLabelSeconds.setText(
                                Integer.toString(seconds % 60));
                        timerLabelMinutes.setText(
                                Integer.toString(seconds / 60));

                        if (seconds <= 0) {
                            timeline.stop();
                        }
                    }
                    ));
            timeline.playFromStart();
        }
        );
        buttonC.setOnAction(
                (event) -> {
                    System.out.println("Show the study history");
                    window.setScene(third);

                }
        );
        buttonD.setOnAction(
                (event) -> {
                    System.out.println("Have a break");
                    window.setScene(four);

                }
        );

        //functionalities of the buttons of Set time in minutes scene
        backToStart.setOnAction(
                (event) -> {

                    window.setScene(first);

                }
        );
        setTime.setOnAction(
                (event) -> {
                    System.out.println("Going to the starting window");
                    window.setScene(first);

                }
        );
        //functionalities of the buttons of analytics
        backToStartAnalytics.setOnAction(
                (event) -> {
                    System.out.println("Going to the starting window");
                    window.setScene(first);

                }
        );
        //functionalities of the buttons of brake window
        backFromBrake.setOnAction(
                (event) -> {
                    System.out.println("Going to the starting window");
                    window.setScene(first);

                }
        );

        //here will be the scene for study analytics
        window.setScene(first);

        window.show();
    }

    public static void main(String[] args) {
        launch(timerUIJavaFX.class
        );
    }

}
