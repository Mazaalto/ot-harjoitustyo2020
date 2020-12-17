/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import java.util.HashMap;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import studyclock.domain.StudyClockService;

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    private Timeline timeline;
    private final Label middle = new Label(":");
    private final Label timerLabelMinutes = new Label("25");
    private final Label timerLabelSeconds = new Label("00");
    private final Label frase = new Label("");
    private StudyClockService service;

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");
        //Here is the logic of the app, default time is one pomodoro, that is 25*60 = 1500s
        this.service = new StudyClockService();

        //Setting up the mainScene
        BorderPane mainScene = new BorderPane();
        Button start = new Button("Start the timer");
        Button stop = new Button("Give up");
        start.setStyle("-fx-font-size: 2em");
        start.setTextFill(Color.GOLDENROD);
        stop.setStyle("-fx-font-size: 2em");
        stop.setTextFill(Color.GOLDENROD);
        Button history = new Button("Show the study history");
        history.setStyle("-fx-font-size: 2em");
        history.setTextFill(Color.GOLDENROD);
        Button setup = new Button("Adjust the timer");
        setup.setStyle("-fx-font-size: 2em");
        setup.setTextFill(Color.GOLDENROD);
        TextField secondsInText = new TextField();
        secondsInText.setText(Integer.toString(this.service.getSeconds()));

        secondsInText.textProperty().addListener((change, oldValue, newValue) -> {
            //when the timer is finished there is a pop up window, alert
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

            } else if (newValue.equals("-1") && this.service.getType().equals("stop")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("You stopped the timer");
                alert.setHeaderText("In pomodoro you study for 25 minutes without stop");
                alert.setContentText("You can start a new timer in Adjust the timer");
                alert.show();

            }
        });

        HBox buttons = new HBox();
        buttons.setSpacing(100);
        buttons.getChildren().add(start);
        buttons.getChildren().add(stop);
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
                            this.service.addTimer();
                            secondsInText.setText("-1");

                        }

                    }
                    ));
            timeline.playFromStart();

        }
        );
        stop.setOnAction((event) -> {

            this.service.setSeconds(0);
            this.service.setType("stop");

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
        setTime.setStyle("-fx-font-size: 1.5em");
        setTime.setTextFill(Color.GOLDENROD);
        Button backToStart = new Button("Go back");
        backToStart.setStyle("-fx-font-size: 1.5em");
        backToStart.setTextFill(Color.GOLDENROD);
        Label choose = new Label("Will you study or have a break?");
        Button chooseStudy = new Button("Studying");
        chooseStudyOrBrake.getChildren().add(chooseStudy);

        chooseStudy.setStyle("-fx-font-size: 1.5em");
        chooseStudy.setTextFill(Color.GOLDENROD);
        Button chooseBreak = new Button("Break");
        chooseStudyOrBrake.getChildren().add(chooseBreak);
        chooseBreak.setStyle("-fx-font-size: 1.5em");
        chooseBreak.setTextFill(Color.GOLDENROD);
        Button setSubject = new Button("Set subject");
        setSubject.setStyle("-fx-font-size: 1.5em");
        setSubject.setTextFill(Color.GOLDENROD);
        Label instructions = new Label("Here you can set time in minutes");

        TextField minutesInText = new TextField();
        Label instructionsForSub = new Label("Here you can write a subject you are studying for analytics");
        TextField subjecInText = new TextField();
        VBox buttonsSetTime = new VBox();
        Button backFromSetup = new Button("Go back");
        backFromSetup.setStyle("-fx-font-size: 1.5em");
        backFromSetup.setTextFill(Color.GOLDENROD);

        buttonsSetTime.setSpacing(5);
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
                    choose.setText("You chose to study");
                    this.service.setType("study");

                }
        );
        chooseBreak.setOnAction(
                (event) -> {
                    choose.setText("You chose to have a break");
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
                        instructions.setText("Remember to adjust time in minutes");
                        frase.setText("Remember to adjust time in minutes");
                    }
                    instructions.setText("Time is set");
                    window.setScene(settingup);

                }
        );
        //here we get the subject for service and analytics

        setSubject.setOnAction(
                (event) -> {
                    String subject = subjecInText.getText();
                    this.service.setSubject(subject);
                    instructionsForSub.setText("Subject is set");
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

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc
                = new BarChart<>(xAxis, yAxis);
        bc.setTitle("How close to goal");
        xAxis.setLabel("");
        yAxis.setLabel("Hours");
        XYChart.Series series = new XYChart.Series();
        series.setName("today");
        series.getData().add(new XYChart.Data("goal", this.service.getGoal()));
        series.getData().add(new XYChart.Data("done", this.service.sumOfHashMap()));
        bc.getData().addAll(series);
        graphScene.setLeft(bc);

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Tira", 13),
                        new PieChart.Data("Networking", 25),
                        new PieChart.Data("Tito", 10),
                        new PieChart.Data("Ohtu", 22),
                        new PieChart.Data("Coding", 30));

        PieChart chartpie = new PieChart(pieChartData);
        chartpie.setTitle("Example Subjects of the day");
        chartpie.setLabelLineLength(30);
        chartpie.setLegendSide(Side.RIGHT);
        graphScene.setRight(chartpie);
        VBox buttonsAnalytics = new VBox();
        Button backToStartAnalytics = new Button("Go back");
        backToStartAnalytics.setStyle("-fx-font-size: 1.5em");
        backToStartAnalytics.setTextFill(Color.GOLDENROD);
        buttonsAnalytics.setSpacing(15);
        Label text2 = new Label("Set a goal of hours to study daily");
        TextField goalAsText = new TextField();
        Button goal = new Button("Set the goal");
        goal.setStyle("-fx-font-size: 1.5em");
        goal.setTextFill(Color.GOLDENROD);
        Button graph = new Button("Update the graphs");
        graph.setStyle("-fx-font-size: 1.5em");
        graph.setTextFill(Color.GOLDENROD);
        Label instructionsForSave = new Label("Here you can save your history");
        Button saveTheHistory = new Button("Save the history to memory");
        saveTheHistory.setStyle("-fx-font-size: 1.5em");
        saveTheHistory.setTextFill(Color.GOLDENROD);
        buttonsAnalytics.getChildren().add(text2);
        buttonsAnalytics.getChildren().add(goalAsText);
        buttonsAnalytics.getChildren().add(goal);
        buttonsAnalytics.getChildren().add(graph);
        buttonsAnalytics.getChildren().add(instructionsForSave);
        buttonsAnalytics.getChildren().add(saveTheHistory);
        buttonsAnalytics.getChildren().add(backToStartAnalytics);
        graphScene.setBottom(buttonsAnalytics);
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
                        text2.setText("The goal is set");

                    } else {
                        instructions.setText("Input time in minutes");
                        text2.setText("Remember to adjust time in hours");
                        frase.setText("Remember to adjust time in hours");
                    }

                }
        );
        //Here is the setting up of the graph

        graph.setOnAction(
                (event) -> {
                    //if there is not enough data, show this
                    HashMap<String, Integer> map = this.service.calculatePercentages();

                    if (map.isEmpty()) {
                        ObservableList<PieChart.Data> notEnoughData
                        = FXCollections.observableArrayList(
                                new PieChart.Data("Not enough data", 100));
                        final PieChart chart2 = new PieChart(notEnoughData);

                        graphScene.setRight(chart2);

                    } else {
                        //if there is enough data, show this
                        ObservableList<PieChart.Data> thereIsEnoughData
                        = FXCollections.observableArrayList();

                        for (String key : map.keySet()) {
                            PieChart.Data data = new PieChart.Data(key, (int) map.get(key));
                            thereIsEnoughData.add(data);
                        }

                        final PieChart chart3 = new PieChart(thereIsEnoughData);
                        graphScene.setRight(chart3);
                    }
                    // here is if we update the goal
                    BarChart<String, Number> bc2
                    = new BarChart<>(xAxis, yAxis);
                    bc2.setTitle("How close to goal");
                    xAxis.setLabel("");
                    yAxis.setLabel("Hours");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("today");
                    series2.getData().add(new XYChart.Data("goal", this.service.getGoal()));
                    series2.getData().add(new XYChart.Data("done", this.service.sumOfHashMap() / 60));
                    bc2.getData().addAll(series2);
                    graphScene.setLeft(bc2);

                }
        );
        //Save the history to file
        saveTheHistory.setOnAction(
                (event) -> {
                    boolean result = this.service.saveFile();
                    if (result) {
                        instructionsForSave.setText("Your history is saved");
                    }
                    instructionsForSave.setText("This feature is not available yet");

                }
        );

        //Going to the starting window
        backToStartAnalytics.setOnAction(
                (event) -> {
                    window.setScene(first);

                }
        );

        window.setScene(first);
        window.show();

    }

    public static void main(String[] args) {
        launch(timerUIJavaFX.class
        );
    }

}
