package com.metricconverter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverter extends Application {
  private TextField tfConversionAmount = new TextField();
  private TextField tfResult = new TextField();
  private Button btCalculate = new Button("Calculate");

  final ToggleGroup group = new ToggleGroup();
  private RadioButton rb1 = new RadioButton("KilogramsToPounds");
  private RadioButton rb2 = new RadioButton("KilometersToMiles");
  private RadioButton rb3 = new RadioButton("GramsToOunces");
  private RadioButton rb4 = new RadioButton("SquareFeetToAcres");


  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    rb1.setToggleGroup(group);
    rb2.setToggleGroup(group);
    rb3.setToggleGroup(group);
    rb4.setToggleGroup(group);

    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Conversion Amount:"), 0, 0);
    gridPane.add(tfConversionAmount, 1, 0);
    gridPane.add(new Label("Conversion Type:"), 0, 1);
    gridPane.add(rb1, 1, 1);
    gridPane.add(rb2, 1, 2);
    gridPane.add(rb3, 1, 3);
    gridPane.add(rb4, 1, 4);
    gridPane.add(btCalculate, 1, 5);
    gridPane.add(new Label("Result:"), 0, 6);
    gridPane.add(tfResult, 1, 6);

    
    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfConversionAmount.setAlignment(Pos.BOTTOM_RIGHT);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);
    tfResult.setEditable(false);

    // Process events
    btCalculate.setOnAction(e -> calculateMetricConversion());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Metric Converter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

   private void calculateMetricConversion() {
    if (tfConversionAmount.getText() != "") {
      double conversionAmount = Double.parseDouble(tfConversionAmount.getText());
      RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
      MetricConversion metricConv = new MetricConversion();
      tfResult.setText(metricConv.conversion(selectedRadioButton.getText(), conversionAmount));
    }

  }
  
  public static void main(String[] args) {
    launch(args);
  }
}