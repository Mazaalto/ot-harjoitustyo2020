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

    private Integer starttime = 20;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private IntegerProperty timeInSeconds = new SimpleIntegerProperty(starttime);

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");

        //Here is the logic of the app
        StudyClockService service = new StudyClockService();

        //starting the commands
        BorderPane mainScene = new BorderPane();

        Button buttonA = new Button("Set time in minutes");
        Button buttonB = new Button("Start the timer");
        Button buttonC = new Button("Show the study history");
        Button buttonD = new Button("Have a break");

        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.getChildren().add(buttonA);
        buttons.getChildren().add(buttonB);
        buttons.getChildren().add(buttonC);
        buttons.getChildren().add(buttonD);

        mainScene.setTop(buttons);
        mainScene.setCenter(timerLabel);

        //Scenes
        Scene first = new Scene(mainScene);
        //Get the time to study from user (esim textboxista)
        long studyTime = 1;
        //tähän testailen nyt ajastinta

        //testi timerin näytölle
        timerLabel.setTextFill(Color.ORANGERED);
        timerLabel.textProperty().bind(timeInSeconds.asString());
        timerLabel.setStyle("-fx-font-size: 30em;");

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
            timeInSeconds.set(starttime);
            timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(starttime + 1),
                            new KeyValue(timeInSeconds, 0)));
            timeline.playFromStart();

        });
        buttonC.setOnAction((event) -> {
            System.out.println("Show the study history");
            window.setScene(third);

        });
        buttonD.setOnAction((event) -> {
            System.out.println("Have a break");
            window.setScene(four);

        });

        //functionalities of the buttons of Set time in minutes scene
        backToStart.setOnAction((event) -> {

            window.setScene(first);

        });
        setTime.setOnAction((event) -> {
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
