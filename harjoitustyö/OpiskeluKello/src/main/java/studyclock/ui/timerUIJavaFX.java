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
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import studyclock.domain.StudyClockService;
import studyclock.domain.Timer;

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    private int seconds;
    private Timeline timeline;
    private Label timerLabelMinutes = new Label("25");
    private Label timerLabelSeconds = new Label("00");
    private final Label middle = new Label(":");
    private Label frase = new Label("");
    private StudyClockService service;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");
        //Here is the logic of the app
        this.service = new StudyClockService();
        //default time is one pomodoro, that is 25*60 = 1500s
//        this.seconds = 1500;
        this.seconds = 5;

        //Setting up the mainScene
        BorderPane mainScene = new BorderPane();

        Button start = new Button("Start the timer");
        start.setStyle("-fx-font-size: 2em");
        start.setTextFill(Color.GOLDENROD);
        Button history = new Button("Show the study history");
        history.setStyle("-fx-font-size: 2em");
        history.setTextFill(Color.GOLDENROD);
        Button setup = new Button("Set timer for studying or a break");
        setup.setStyle("-fx-font-size: 2em");
        setup.setTextFill(Color.GOLDENROD);
        TextField secondsInText = new TextField();

        //VOISKO TEHDÄ NOIHIN TIMERLABELEIHIN LISTENERIN JOKA SITTEN JOS KUMPIKIN 0 NIIN TEKEE JOTAIN?!"
        //testaan siis sitä että tähän textfieldiin on tallennettuna siis sekunnit, en laita näkyviin, jos muuttuu "0" sitten tulee alert
        secondsInText.setText(Integer.toString(seconds));

        secondsInText.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            System.out.println(vanhaArvo + " -> " + uusiArvo);

            if (uusiArvo.equals("-1")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Well done");
                alert.setHeaderText("You did it!");
                alert.setContentText("Now you can relax for a bit or start studying");

                alert.show();

            }
        });

        HBox buttons = new HBox();
        buttons.setSpacing(130);
        buttons.getChildren().add(start);
        buttons.getChildren().add(history);
        buttons.getChildren().add(setup);

        mainScene.setTop(buttons);
        mainScene.setLeft(timerLabelMinutes);
        mainScene.setRight(timerLabelSeconds);
        mainScene.setCenter(middle);
        mainScene.setBottom(frase);
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
                        //secondsInText.setText(Integer.toString(seconds));

                        // update timerLabels minutes and seconds
                        timerLabelSeconds.setText(
                                Integer.toString(seconds % 60));
                        timerLabelMinutes.setText(
                                Integer.toString(seconds / 60));

                        if (seconds <= 0) {
                            timeline.stop();
                            secondsInText.setText("-1");
                            

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
        frase.setStyle("-fx-font-size: 1em;");
        middle.setStyle("-fx-font-size: 15em;");

        //Scene in Set time in minutes
        Button setTime = new Button("Set time");
        Button backToStart = new Button("Go back");
        Button setSubject = new Button("Set subject");
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
        buttonsSetTime.getChildren().add(setSubject);
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
                    String intString = minutesInText.getText();
                    if (this.service.checkIfInt(intString)) {
                        this.seconds = service.getStringToInt(intString) * 60;

                        timerLabelSeconds.setText(
                                Integer.toString(seconds % 60));
                        timerLabelMinutes.setText(
                                Integer.toString(seconds / 60));

                    } else {
                        instructions.setText("Input time in minutes");
                        frase.setText("Remember to adjust time in minutes");
                    }
                    window.setScene(settingup);

                }
        );
        //here we get the subject for service and analytics

        setSubject.setOnAction(
                (event) -> {
                    String subject = subjecInText.getText();
                    window.setScene(settingup);
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
        //Onnistui löytymään alerttilaatikko, tätä testataan

    }

    public static void main(String[] args) {
        launch(timerUIJavaFX.class
        );
    }

}
