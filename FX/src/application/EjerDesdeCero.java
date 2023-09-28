package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjerDesdeCero extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage escenario) throws Exception{
		Text mensaje = new Text("");
		Button aceptarBtn = new Button("Hola");
		Button cerrarBtn = new Button("Cerrar");
		TextField textField = new TextField();
		aceptarBtn.setOnAction(event -> {
			if (textField.getText().equals("Obi wan")) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				Color blue = Color.web("rgb(0, 0, 255)");
				
			    alert.setHeaderText(null);
			    alert.setTitle("Info");
			    alert.setContentText("¡General Kenobi!");
			    alert.showAndWait();
			}else {
				mensaje.setText("Hola "+textField.getText());
			}
		});
		cerrarBtn.setOnAction(event -> {
			System.exit(0);
		});
		VBox raiz = new VBox();
		raiz.getChildren().add(textField);
		raiz.getChildren().add(aceptarBtn);
		raiz.getChildren().add(mensaje);
		raiz.getChildren().add(cerrarBtn);
		Scene escena = new Scene(raiz, 300, 100);
		escenario.setResizable(false);
		escenario.setTitle("Ejercicio desde cero");
		escenario.setScene(escena);
		String url = getClass().getResource("resources/css/buttonstyles.css").toString();
		escena.getStylesheets().add(url);
		escenario.show();
	}
	
}
