package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage escenario) throws Exception{
		Text mensaje = new Text("hola mundo");
		Button holaBtn = new Button("Hola");
		holaBtn.setOnAction(event -> {
			mensaje.setText("hola");
		});
		Button adiosBtn = new Button("Adios");
		adiosBtn.setOnAction(event -> {
			mensaje.setText("adios");
		});
		
		VBox raiz = new VBox();
		raiz.getChildren().add(mensaje);
		raiz.getChildren().add(holaBtn);
		raiz.getChildren().add(adiosBtn);
		Scene escena = new Scene(raiz, 300, 100);
		escenario.setTitle("HolaFX Aplicacion");
		escenario.setScene(escena);
		escenario.show();
	}

}
