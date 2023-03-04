package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {


	@Override
	public void start(Stage stage) {
		try {
			Label topLabel = new Label("BMI-Rechner");
			topLabel.setId("top");
			HBox top = new HBox(topLabel);
			top.setAlignment(Pos.CENTER);
			// HBox top=new HBox(topLabel);

			// Center-Bereich
			Label labelGewicht = new Label("Gewicht [kg]:  ");
			TextField textFieldGewicht = new TextField();
			HBox hBoxGewicht = new HBox(labelGewicht, textFieldGewicht);

			Label labelSize = new Label("Größe [cm]:    ");
			TextField textFieldSize = new TextField();
			HBox hBoxSize = new HBox(labelSize, textFieldSize);
			Label labelBMI = new Label("BMI:  ");
			Label outputBMI =new Label();
			HBox hBoxBMI = new HBox(labelBMI, outputBMI);
			hBoxBMI.setVisible(false);
			hBoxBMI.setAlignment(Pos.CENTER);
			VBox entryPane = new VBox(hBoxGewicht, hBoxSize,hBoxBMI);
			entryPane.setAlignment(Pos.CENTER);
	
			// Buttons:
			Button bRechnen = new Button("Berechnen");
			bRechnen.setOnAction(e -> {
				try {
					
					double weight=Double.parseDouble(textFieldGewicht.getText().replace(',','.'));
					double size=Double.parseDouble(textFieldSize.getText().replace(',', '.'))/100;
					double bmi=weight/(size*size);
					bmi=Math.round(bmi*100)/100.0;
					if(bmi>26) {
						outputBMI.setId("bmiRed");
						labelBMI.setId("bmiRed");
						
					}
					else {
						
						outputBMI.setId("bmiGreen");
						labelBMI.setId("bmiGreen");
					}
					outputBMI.setText(String.valueOf(bmi));
					hBoxBMI.setVisible(true);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Bitte Felder korrekt ausfüllen");
					alert.showAndWait();
				}

			});
			Button bReset = new Button("Zurücksetzen");
			bReset.setOnAction(e -> {
				textFieldGewicht.setText("");
				textFieldSize.setText("");
				hBoxBMI.setVisible(false);
				
			});
			HBox buttonPane = new HBox(bRechnen, bReset);
			buttonPane.setAlignment(Pos.CENTER);
			//Pane
			BorderPane pane = new BorderPane();
			pane.setCenter(entryPane);
			pane.setBottom(buttonPane);
			pane.setTop(top);
			Scene scene = new Scene(pane, 300, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toString());
			pane.setCenter(entryPane);
			pane.setBottom(buttonPane);
			pane.setTop(top);
			stage.setTitle("BMI-Rechner");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
