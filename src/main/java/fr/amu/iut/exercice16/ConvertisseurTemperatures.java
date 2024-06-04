package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);

        Slider celsius = new Slider(0,100, 0.5);
        celsius.setShowTickMarks(true);
        celsius.setShowTickLabels(true);
        celsius.setOrientation(Orientation.VERTICAL);

        Slider fahrenheit = new Slider(0,212, 0.5);
        fahrenheit.setShowTickMarks(true);
        fahrenheit.setShowTickLabels(true);
        fahrenheit.setOrientation(Orientation.VERTICAL);

        panneauCelsius.getChildren().add(celsius);
        panneauFahrenheit.getChildren().add(fahrenheit);

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}