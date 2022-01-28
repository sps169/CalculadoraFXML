package ies.luisvives.org.calculadorafxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("calculator-view.fxml"));
		fxmlLoader.setController(new CalculatorController(new CalculatorModel()));
		Parent root = fxmlLoader.load();
		root.getStyleClass().add(JMetroStyleClass.BACKGROUND);
		JMetro style = new JMetro(Style.DARK);
		Scene scene = new Scene(root, 320, 240);
		style.setScene(scene);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}