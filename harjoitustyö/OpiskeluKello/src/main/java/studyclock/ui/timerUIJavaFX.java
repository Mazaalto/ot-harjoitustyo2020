/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    private int seconds;
    private Timeline timeline;
    private Label timerLabelMinutes = new Label("25");
    private Label timerLabelSeconds = new Label("00");
    private Label middle = new Label(":");
    private StudyClockService service;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");
        //Here is the logic of the app
        StudyClockService service = new StudyClockService();
        //default time is one pomodoro, that is 25*60 = 1500s
        this.seconds = 1500;

        //refraktoroin koodin niin että funktionaalisuudet aina ko. kenttien alla
        //nämä siirretään niin että voi valita oikeasta ikkunasta niiden arvot, esim muutetaan minuutit sekunneiksi
        //nyt taitaa olla niin että aika aina sekunteina, muutetaan vasta näytillä minuuteiksi ja sekunneiksi
        //tehdään niin että operoidaan vaan sekunneilla siis, tallenetaan ne studyserviceen talteen
        //Setting up the mainScene
        BorderPane mainScene = new BorderPane();

        Button start = new Button("Start the timer");
        Button history = new Button("Show the study history");
        Button setup = new Button("Set timer for studying or a break");
        HBox buttons = new HBox();
        buttons.setSpacing(180);
        buttons.getChildren().add(start);
        buttons.getChildren().add(history);
        buttons.getChildren().add(setup);

        mainScene.setTop(buttons);
        mainScene.setLeft(timerLabelMinutes);
        mainScene.setRight(timerLabelSeconds);
        mainScene.setCenter(middle);
        Scene first = new Scene(mainScene);

        //starting the timer in the mainScene from start button
        start.setOnAction((event) -> {

            if (timeline != null) {
                timeline.stop();
            }

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

        //Setting up the timer UI
        timerLabelMinutes.setTextFill(Color.GOLDENROD);
        timerLabelSeconds.setTextFill(Color.SILVER);
        timerLabelMinutes.setStyle("-fx-font-size: 30em;");
        timerLabelSeconds.setStyle("-fx-font-size: 30em;");
        middle.setStyle("-fx-font-size: 15em;");

        //Scene in Set time in minutes
        Button setTime = new Button("Set time");
        Button backToStart = new Button("Go back");
        Label instructions = new Label("Here you can set the time for the studying or break");
        TextField minutesInText = new TextField();
        Label instructionsForSub = new Label("Here you can write a subject you are studying for analytics");
        TextField subjecInText = new TextField();
        VBox buttonsSetTime = new VBox();
        Button backFromSetup = new Button("go back");
        buttonsSetTime.setSpacing(15);
        buttonsSetTime.getChildren().add(instructions);
        buttonsSetTime.getChildren().add(minutesInText);
        buttonsSetTime.getChildren().add(setTime);
        buttonsSetTime.getChildren().add(instructionsForSub);
        buttonsSetTime.getChildren().add(subjecInText);
        buttonsSetTime.getChildren().add(backToStart);
        Scene settingup = new Scene(buttonsSetTime);

        //buttons fuctions in setTime
        setup.setOnAction(
                (event) -> {
                    window.setScene(settingup);

                }
        );
        backToStart.setOnAction(
                (event) -> {
                    window.setScene(first);

                }
        );
        setTime.setOnAction(
                (event) -> {
                    //here we check the time is within limits and add it to studyclock service
                    window.setScene(first);

                }
        );
        backFromSetup.setOnAction(
                (event) -> {
                    window.setScene(first);
                }
        );

        //Scene where is the analytics
        Button backToStartAnalytics = new Button("go back");
        HBox buttonsAnalytics = new HBox();
        buttonsAnalytics.setSpacing(15);
        buttonsAnalytics.getChildren().add(backToStartAnalytics);
        Label text2 = new Label("Here you will see your study history");
        buttonsAnalytics.getChildren().add(text2);
        Scene analytics = new Scene(buttonsAnalytics);

        history.setOnAction(
                (event) -> {
                    System.out.println("Show the study history");
                    window.setScene(analytics);

                }
        );

        //Going to the starting window
        backToStartAnalytics.setOnAction(
                (event) -> {
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
