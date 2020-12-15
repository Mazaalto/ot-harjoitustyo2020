/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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

    private Timeline timeline;
    private final Label middle = new Label(":");
    private Label timerLabelMinutes = new Label("25");
    private Label timerLabelSeconds = new Label("00");
    private Label frase = new Label("");
    private StudyClockService service;
    //type defines is the timer for studying or brake
    //private String type;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");
        //Here is the logic of the app, default time is one pomodoro, that is 25*60 = 1500s
        this.service = new StudyClockService();

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
        secondsInText.setText(Integer.toString(this.service.getSeconds()));

        secondsInText.textProperty().addListener((change, oldValue, newValue) -> {

            if (newValue.equals("-1") && this.service.getType().equals("study")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Well done");
                alert.setHeaderText("You did it!");
                alert.setContentText("Now you can relax for five minutes");
                this.service.setSeconds(300);
                timerLabelSeconds.setText(
                        Integer.toString(this.service.getSeconds() % 60));
                timerLabelMinutes.setText(
                        Integer.toString(this.service.getSeconds() / 60));

                this.service.setType("break");
                alert.show();

            } else if (newValue.equals("-1") && this.service.getType().equals("break")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Let's do it!");
                alert.setHeaderText("Break is over");
                alert.setContentText("In pomodoro you study 25 minutes and relax 5");
                alert.show();

            }
        });

        HBox buttons = new HBox();
        buttons.setSpacing(130);
        buttons.getChildren().add(start);
        buttons.getChildren().add(setup);
        buttons.getChildren().add(history);

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
            this.service.addTimer();

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(1), (ActionEvent event1) -> {
                        this.service.minusSeconds();

                        // update timerLabels minutes and seconds
                        timerLabelSeconds.setText(
                                Integer.toString(this.service.getSeconds() % 60));
                        timerLabelMinutes.setText(
                                Integer.toString(this.service.getSeconds() / 60));

                        if (this.service.getSeconds() <= 0) {
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
        HBox chooseStudyOrBrake = new HBox();
        chooseStudyOrBrake.setSpacing(5);
        Button setTime = new Button("Set time");
        setTime.setStyle("-fx-font-size: 2em");
        setTime.setTextFill(Color.GOLDENROD);
        Button backToStart = new Button("Go back");
        backToStart.setStyle("-fx-font-size: 2em");
        backToStart.setTextFill(Color.GOLDENROD);
        Label choose = new Label("Will you study or have a break?");
        Button chooseStudy = new Button("Studying");
        chooseStudyOrBrake.getChildren().add(chooseStudy);

        chooseStudy.setStyle("-fx-font-size: 2em");
        chooseStudy.setTextFill(Color.GOLDENROD);
        Button chooseBreak = new Button("Break");
        chooseStudyOrBrake.getChildren().add(chooseBreak);
        chooseBreak.setStyle("-fx-font-size: 2em");
        chooseBreak.setTextFill(Color.GOLDENROD);
        Button setSubject = new Button("Set subject");
        setSubject.setStyle("-fx-font-size: 2em");
        setSubject.setTextFill(Color.GOLDENROD);
        Label instructions = new Label("Here you can set the time for the studying or break");
        TextField minutesInText = new TextField();
        Label instructionsForSub = new Label("Here you can write a subject you are studying for analytics");
        TextField subjecInText = new TextField();
        VBox buttonsSetTime = new VBox();
        Button backFromSetup = new Button("go back");
        backFromSetup.setStyle("-fx-font-size: 2em");
        backFromSetup.setTextFill(Color.GOLDENROD);

        buttonsSetTime.setSpacing(15);
        buttonsSetTime.getChildren().add(choose);
        buttonsSetTime.getChildren().add(chooseStudyOrBrake);
        buttonsSetTime.getChildren().add(instructions);
        buttonsSetTime.getChildren().add(minutesInText);
        buttonsSetTime.getChildren().add(setTime);
        buttonsSetTime.getChildren().add(instructionsForSub);
        buttonsSetTime.getChildren().add(subjecInText);
        buttonsSetTime.getChildren().add(setSubject);
        buttonsSetTime.getChildren().add(backToStart);
        Scene settingup = new Scene(buttonsSetTime);

        chooseStudy.setOnAction(
                (event) -> {

                    this.service.setType("study");

                }
        );
        chooseBreak.setOnAction(
                (event) -> {

                    this.service.setType("break");

                }
        );
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
                        this.service.setSeconds(service.getStringToInt(intString) * 60);

                        timerLabelSeconds.setText(
                                Integer.toString(this.service.getSeconds() % 60));
                        timerLabelMinutes.setText(
                                Integer.toString(this.service.getSeconds() / 60));

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
                    this.service.setSubject(subject);
                    window.setScene(settingup);
                }
        );
        backFromSetup.setOnAction(
                (event) -> {
                    window.setScene(first);
                }
        );

        //Scene where is the analytics
        BorderPane graphScene = new BorderPane();
        Scene scene = new Scene(graphScene);
        //the total time studied chart per day
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        x.setLabel("Day");
        y.setLabel("Hours");
        LineChart<Number, Number> chart = new LineChart<>(x, y);
        chart.setTitle("Your study history");

        XYChart.Series goalData = new XYChart.Series();
        XYChart.Series studyData = new XYChart.Series();
        goalData.setName("Goal");
        studyData.setName("Study history");

        int goalInt = this.service.getGoal();
        for (int i = 0; i < 7; i++) {
            goalData.getData().add(new XYChart.Data(i, goalInt));
        }
        //tähän testinä parit eri timerit
        this.service.addTimer();
        ArrayList<Timer> lista = this.service.getHistory().getList();

        for (int i2 = 0; i2 < lista.size(); i2++) {
            //nyt pitää miettiä miten lasken samat päivät yhteen, enkä näytä vaan timereita, pitäiskö itseasiassa tehdä muualla.. esim serviisissä
        }

        chart.getData().add(goalData);
        graphScene.setLeft(chart);

//                    window.setTitle("Study History");
//                    window.setWidth(600);
//                    window.setHeight(600);
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Tira", 13),
                        new PieChart.Data("Networking", 25),
                        new PieChart.Data("Tito", 10),
                        new PieChart.Data("Ohtu", 22),
                        new PieChart.Data("Coding", 30));
        final PieChart chartpie = new PieChart(pieChartData);
        chartpie.setTitle("Example Subjects Studied");
        chartpie.setLabelLineLength(30);
        chartpie.setLegendSide(Side.RIGHT);

        graphScene.setRight(chartpie);

        VBox buttonsAnalytics = new VBox();
        Button backToStartAnalytics = new Button("go back");
        buttonsAnalytics.setSpacing(15);
        Label text2 = new Label("Set a goal of hours to study daily");
        TextField goalAsText = new TextField();
        Button goal = new Button("Set the goal");
        Button graph = new Button("Show the history as a graph");
        buttonsAnalytics.getChildren().add(text2);
        buttonsAnalytics.getChildren().add(goalAsText);
        buttonsAnalytics.getChildren().add(goal);
        buttonsAnalytics.getChildren().add(graph);
        //window.setScene(scene);
        buttonsAnalytics.getChildren().add(backToStartAnalytics);
        graphScene.setBottom(buttonsAnalytics);

        //Scene analytics = new Scene(buttonsAnalytics);
        window.setScene(scene);
        window.show();

        history.setOnAction(
                (event) -> {

                    window.setScene(scene);

                }
        );
        goal.setOnAction(
                (event) -> {
                    String intString = goalAsText.getText();
                    if (this.service.checkIfInt(intString)) {
                        this.service.setGoal(service.getStringToInt(intString));

                    } else {
                        instructions.setText("Input time in minutes");
                        frase.setText("Remember to adjust time in hours");
                    }

                }
        );
        //Here is the setting up of the graph

        //show the graph
        graph.setOnAction(
                (event) -> {
//                    //here we change the values to the correct ones

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
