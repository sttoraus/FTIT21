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

public class Main2 extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Label topLabel = new Label("BMI-Rechner");
			HBox top = new HBox(topLabel);
			top.setAlignment(Pos.CENTER);
			Label labelGewicht = new Label("Gewicht [kg]:  ");
			TextField textFieldGewicht = new TextField();
			HBox hBoxGewicht = new HBox(labelGewicht, textFieldGewicht);

			Label labelSize = new Label("Größe [cm]:    ");
			TextField textFieldSize = new TextField();
			HBox hBoxSize = new HBox(labelSize, textFieldSize);
			Label labelBMI = new Label("BMI:  ");
			Label outputBMI =new Label();
			HBox hBoxBMI = new HBox(labelBMI, outputBMI);
			hBoxBMI.setAlignment(Pos.CENTER);
			VBox entryPane = new VBox(hBoxGewicht, hBoxSize,hBoxBMI);
			entryPane.setAlignment(Pos.CENTER);
	
			// Buttons:
			Button bRechnen = new Button("Berechnen");
			bRechnen.setOnAction(e -> {
				

			});
			Button bReset = new Button("Zurücksetzen");
			bReset.setOnAction(e -> {
				
			});
			HBox buttonPane = new HBox(bRechnen, bReset);
			buttonPane.setAlignment(Pos.CENTER);
			//Pane
			BorderPane pane = new BorderPane();
			pane.setCenter(entryPane);
			pane.setBottom(buttonPane);
			pane.setTop(top);
			Scene scene = new Scene(pane, 300, 200);
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
