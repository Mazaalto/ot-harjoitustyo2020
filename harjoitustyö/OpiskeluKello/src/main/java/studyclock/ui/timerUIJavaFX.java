/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author mazaalto
 */
public class timerUIJavaFX extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("the Study Clock");
        
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        Button buttonA = new Button("Set time in minutes");
        Button buttonB = new Button("Start the timer");
        Button buttonC = new Button("Show the study history");
        Button buttonD = new Button("Have a brake");
        
        
        Label text = new Label("Here you can choose how many minutes you want to study");

        //GridPane components = new GridPane();
       
        buttons.getChildren().add(buttonA);
        buttons.getChildren().add(buttonB);
        buttons.getChildren().add(buttonC);
        buttons.getChildren().add(buttonD);

        
        

        Scene nakyma = new Scene(buttons);

        window.setScene(nakyma);
        window.show();
    }

    public static void main(String[] args) {
        launch(timerUIJavaFX.class);
    }

}
